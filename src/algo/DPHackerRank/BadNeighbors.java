package algo.DPHackerRank;

public class BadNeighbors {

	public int maxDonations(int[] d) {
		int N = d.length;
		int[] sum = new int[N];
		boolean[] fl = new boolean[N];
		sum[0] = d[0];
		fl[0] = true;
		for (int i = 1; i < N - 1; i++) {
			int j = i;
			j = i - 2;
			if (j < 0) 
				j = 0;
			else 
				j = sum[j];
			if (sum[i - 1] > j + d[i]) {
				sum[i] = sum[i - 1]; 
				fl[i] = fl[i - 1];
			}
			else {
				sum[i] = j + d[i];
				if (i >= 2)
					fl[i] = fl[i - 2];
			}
			System.out.print(sum[i] + " " + i + " ," );
		}
		if (N >= 3) {
			if (fl[N - 3]) {
				if (sum[N - 3] + d[N - 1] - sum[0] > sum[N - 2]) {
					sum[N - 1] = sum[N - 3] + d[N - 1] - sum[0];
				}
				else {
					sum[N - 1] = sum[N - 2];
				}
			}
			else {
				if (sum[N - 3] + d[N - 1]> sum[N - 2]) {
					sum[N - 1] = sum[N - 3] + d[N - 1];
				}
				else {
					sum[N - 1] = sum[N - 2];
				}
			}
		}
		else if (N == 2){
			sum[N - 1] = Math.max(d[0], d[1]);
		}
		return sum[N - 1];
	}

	public static void main(String[] args) {
		BadNeighbors bn = new BadNeighbors();
		int[] d = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
				  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
				  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
		System.out.println(bn.maxDonations(d));
	}
}
