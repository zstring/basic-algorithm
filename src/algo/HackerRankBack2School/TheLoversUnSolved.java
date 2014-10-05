package algo.HackerRankBack2School;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;
public class TheLoversUnSolved {
	
//	double[][] memo;
	HashMap<Double, HashMap<Double, Double>> d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TheLoversUnSolved sol = new TheLoversUnSolved();
		int T = sc.nextInt();
		double[] N = new double[T];
		double[] K = new double[T];
		for (int i = 0; i < T; i++) {
			N[i] = sc.nextDouble();
			K[i] = sc.nextDouble();
		}
		for (int i = 0; i < T; i++) {
//			sol.memo = new double[N[i] + 1][K[i] + 1];
			sol.d = new HashMap<Double, HashMap<Double, Double>>();
			double val = sol.calcRec(N[i], K[i]);
			System.out.println((int)val);
		}
	}
	
	public double calcRec(double i, double j) {
		if (j < 0) return 0;
		if (j == 1) return i % 100003;
		if (j == 0) return 1;
		if (i < 2 *j -1) return 0;
		else if (i == 2 * j - 1) return 1;
		
		double n = i - j + 1;
		double va = 1;
		double jj = j;
		if (n - j < j) {
			jj = n - j;
			j = jj;
		}
		double div = 1;
		BigInteger b1 = new BigInteger("1");
		BigInteger b2 = new BigInteger("1");
		j = 1;
		while (jj >= j) {
			String sn = (int)n + "";
			String sj = (int)j + "";
			BigInteger bn = new BigInteger(sn);
			BigInteger bj = new BigInteger(sj);
			b1 = b1.multiply(bn);
			b2 = b2.multiply(bj);
			n--;
			j++;
		}
		
			b1 = b1.divide(b2).mod(new BigInteger("100003"));
//		va = (va / div) % 100003;
		return b1.intValue();
//		
////		if (memo[i][j] != 0) return memo[i][j] % 100003;
//		if (d.containsKey(i) && d.get(i).containsKey(j)) return d.get(i).get(j);
//		double val = 0;
//		for (int k = 0; k <= j; k++) {
//			double ii = ((Double)(i / 2)).intValue();
//			double v = ((calcRec(ii, k) * calcRec(i - ii, j - k)) % 100003);
//			double vv = ((calcRec(ii - 2, k - 1)  * calcRec(i - ii - 2, j - k - 1)) % 100003);
//			if (v < vv) 
//			{
////				System.out.println("PROBLEMS " + v + " " + vv + " ");
//			}
//			val = val + v - vv;
//			val = val % 100003;
//			if (d.containsKey(i)) {
//				HashMap<Double, Double> dd = d.get(i);
//				dd.put(j, val);
//			}
//			else {
//				HashMap<Double, Double> dd = new HashMap<Double, Double>();
//				dd.put(j, val);
//				d.put(i, dd);
//			}
//		}
//		
////		for (int k = i; k >= 2 * j - 1; k--)
////			val += calcRec(k - 2, j - 1) % 100003;
////		memo[i][j] = val;
//		
////		System.out.println("i " + i + " j " + j + " val " + val);
////		return memo[i][j];
//		return val;
	}
}
