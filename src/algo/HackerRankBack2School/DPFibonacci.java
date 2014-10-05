package algo.HackerRankBack2School;

import java.util.Arrays;

public class DPFibonacci {
	private int n;
	private long[] memo;
	
	public DPFibonacci() {
	}
	
	public long calDPFib(int i) {
		this.n = i;
		memo = new long[n];
		return calDPFibRec(i-1);
	}
	public long calDPFibRec(int i) {
		if (memo[i] != 0) return memo[i];
		if (i <= 1) return 1;
		if (i == 45)
			System.out.println("");
		long val = calDPFibRec(i - 1) + calDPFibRec(i - 2);
		memo[i] = val;
		return val;
	}
	
	public static void main(String[] args) {
		DPFibonacci dpFib = new DPFibonacci();
		for (int i = 1; i < 100; i++)
		System.out.print(i + "." + dpFib.calDPFib(i) + ", ");
	}
}
