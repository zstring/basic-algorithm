package algo.HackerRankBack2School;
import java.util.Scanner;
import java.util.HashMap;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ar = new int[N];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			ar[i] = sc.nextInt();
			if (map.containsKey(ar[i])) {
				map.put(ar[i], map.get(ar[i]) + 1);
			}
			else {
				map.put(ar[i], 1);
			}
		}
		
		int max = 0, maxVal = 0;
		int[] a = new int[N];
		a = ar;
		int[] b = new int[N];
		int k = 0;
		while (k < N) {
			for (int i = 0; i < N - 1 - k; i++) {
				b[i] = a[i] ^ a[i + 1];
				if (k > 0) {
					b[i] = b[i] ^ b[i + 1];
				}
				int val = b[i];
				if (map.containsKey(val)) {
					map.put(val, map.get(val) + 1);
				}
				else {
					map.put(val, 1);
				}
				int v = map.get(val);
				if (maxVal < v) {
					maxVal = v;
					max = val;
				}
				else if (maxVal == v) {
					if (max > val) {
						max = val;
					}
				}
			}
			int[] temp = a;
			a = b;
			b = temp;
			k++;
		}
		System.out.println(max + " " + maxVal);
	}
}
