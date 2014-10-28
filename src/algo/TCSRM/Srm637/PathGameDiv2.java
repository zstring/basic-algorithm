package algo.TCSRM.Srm637;

public class PathGameDiv2 {

	public int calc(String[] b) {
		int r = b.length;
		int c = b[1].length();
		int count = 0;
		
		int[][] m = new int[r][c];
		m[0][0] = 0;
		m[1][0] = 0;
		for (int j = 1; j < c; j++) {
			char aPrev = b[0].charAt(j - 1);
			char bPrev = b[1].charAt(j - 1);
			char aCur = b[0].charAt(j);
			char bCur = b[1].charAt(j);
			m[0][j] = 1000;
			m[1][j] = 1000;
			if (bPrev == '.' && bCur == '.') {
				m[1][j] = m[1][j - 1] + 1;;
			}
			if (aPrev == '.' && aCur == '.') {
				m[0][j] = m[0][j - 1] + 1;
			}
			if (aCur == '.' && bCur == '.') {
				if (m[0][j] > m[1][j] + 1) {
					m[0][j] = m[1][j] + 1;
				}
				else if (m[0][j] + 1 < m[1][j]) {
					m[1][j] = m[0][j] + 1;
				}
			}
			if (aCur =='#') {
				m[0][j] = 100;
			}
			if (bCur =='#') {
				m[1][j] = 100;
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (b[i].charAt(j) == '.') {
					count++;
				}
			}
		}
		return count - Math.min(m[0][c - 1], m[1][c - 1]) - 1;
	}
	
	public static void main(String[] args) {
		PathGameDiv2 pgd = new PathGameDiv2();
		String[] b = {"#...."	,"...#."};
		System.out.println(pgd.calc(b));
	}
}
