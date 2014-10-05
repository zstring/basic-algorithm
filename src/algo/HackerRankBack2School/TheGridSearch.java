package algo.HackerRankBack2School;
import java.util.Scanner;
public class TheGridSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int [] R = new int[T];
		int [] C = new int[T];
		int [] r = new int[T];
		int [] c = new int[T];
		String[][] G = new String[T][];
		String[][] P = new String[T][];
		for (int i = 0; i < T; i++) {
			R[i] = sc.nextInt();
			C[i] = sc.nextInt();
			G[i] = new String[R[i]];
			for (int j = 0; j < R[i]; j++) {
				G[i][j] = sc.next();
			}
			r[i] = sc.nextInt();
			c[i] = sc.nextInt();
			P[i] = new String[r[i]];
			for (int j = 0; j < r[i]; j++) {
				P[i][j] = sc.next();
			}
		}
		
		for (int i = 0; i < T; i++) {
			solveMatcherPattern(G[i], P[i], R[i], C[i], r[i], c[i]);
		}
	}

	private static void solveMatcherPattern(String[] s1,
			String[] s2, int R, int C, int r, int c) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= R - r; i++) {
			for (int j = 0; j <= C - c; j++) {
				boolean flag = true;
					for (int k = 0; k < r; k++) {
						String first = s1[i + k].substring(j, j + c);
							if (!first.equals(s2[k])) {
								flag = false;
								break;
							}
					}
					if (flag) {
						System.out.println("YES");
						return;
					}
			}
		}
		System.out.println("NO");
	}
}
