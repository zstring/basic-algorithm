package algo.DPHackerRank;
import java.util.Scanner;

public class PlayGame {
	
	private double solveGame(int[] a) {
		int N = a.length;
		double[] total = new double[N];
		double[] dp = new double[N];
		total[0] = a[0];
		for (int i = 1; i < N; i++) {
			total[i] = total[i - 1] + a[i]; 
		}
		dp[0] = a[0];
		dp[1] = dp[0] + a[1];
		dp[2] = dp[1] + a[2];
		for (int i = 3; i < N; i++) {
			double val = a[i] + total[i - 1] - dp[i - 1];
			val = Math.max(val, a[i] + a[i - 1] + total[i - 2] - dp[i - 2]);
			val = Math.max(val, a[i] + a[i - 1] + a[i - 2] + total[i - 3] - dp[i - 3]);
			dp[i] = val;
		}
		
		return dp[N - 1];
	}
	
	
	public static void main(String[] args) {
		PlayGame pg = new PlayGame();
		int[] w = {999, 1, 1, 1, 0};
		Double[] meYou = {0.0, 0.0};
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (N-- > 0) {
			int len = sc.nextInt();
			int[] a = new int[len];
			for (int i = len - 1; i >= 0; i--) {
				a[i] = sc.nextInt();
			}
			Double d = pg.solveGame(a);
			System.out.println(d.longValue());
		}
	}
}
