package algo.DPHackerRank;
import java.util.Scanner;
public class StockMax {
	private long calMaxProfit(int[] ar) {
		long sum = 0;
		int N = ar.length;
		int max = ar[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			if (ar[i] < max) {
				sum += max - ar[i];
			}
			else if (ar[i] > max) {
				max = ar[i];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		StockMax sm = new StockMax();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int[] ar = new int[N];
			for (int i = 0; i < N; i++) {
				ar[i] = sc.nextInt();
			}
			System.out.println(sm.calMaxProfit(ar));
		}
	}
}
