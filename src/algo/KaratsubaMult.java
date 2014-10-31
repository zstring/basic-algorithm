package algo;

import java.util.Random;

public class KaratsubaMult {

	private final int base;
	public KaratsubaMult (int base) {
		this.base = base;
	}
	public long multiply (int x, int y) {
		long result = 1;
		int xLen = getLength(x);
		int yLen = getLength(y);
		if (xLen == 1 || yLen == 1)
			return x * y;

		int halfX = xLen / 2;
		int halfY = yLen / 2;
		int div = halfX;
		if (halfX > halfY)
			div = halfY;
		int leftX = x / (int) Math.pow(base, div);
		int rightX = x - leftX * (int) Math.pow(base, div);
		
		int leftY = y / (int) Math.pow(base, div);
		int rightY = y - leftY * (int) Math.pow(base, div);

		long a = multiply(leftX, leftY);
		long c = multiply(rightX, rightY);
		long b = multiply(leftX + rightX, leftY + rightY) - a - c;
		result = a * (long) Math.pow(base, 2 * div) +
					b * (long) Math.pow(base, div) + c;
		return result;
	}
	
	private int getLength(int val) {
		if (val == 0) return 1;
		int len = 0;
		while (val > 0) {
			len++;
			val = val / base;
		}
		return len;
	}
	
	
	public static void main(String[] args) {
//		int[] x = {2323, 12, 1231, 1213, 11234, 141523};
//		int[] y = {2323, 31234, 345342, 34534, 25345, 122134334};
//		int[] x = {10};
//		int[] y = {10};
		int N = 100;
		int val = 100000;
		int[] x = new int[N];
		int[] y = new int[N];
		Random r = new Random();
		for (int i = 0; i < N; i++) {
			x[i] = r.nextInt(val);
			y[i] = r.nextInt(val);
		}
		int base = 10;
		KaratsubaMult km = new KaratsubaMult(base);
		for (int i = 0; i < N; i++) {
			long value = km.multiply(x[i], y[i]);
			long actMul =  (long)x[i] * y[i];
			System.out.println(value + " == "+ actMul);
			if (value != actMul) {
				System.out.println("Your Code Not Working!!!");
			}
		}
		
		
	}
}

