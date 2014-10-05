package algo.HackerRankBack2School;

import java.util.Scanner;


public class AlmostSorted {

	public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				int N = sc.nextInt();
				int [] ar = new int[N];
				for (int i = 0; i < N; i++) {
					ar[i] = sc.nextInt();
				}
		
//		int[] ar = {1, 2, 4, 3, 5, 6 , 2, 3};
//		int N = ar.length;
		boolean flagSorted = true;
		boolean flagSwap = false;
		boolean flagReverse = false;
		boolean flagExtra = false;
		int gA = -1, gB = -1, ai = 0, bi = 0;
		for (int i = 1; i < N; i++) {
			int a = ar[i - 1];
			int b=  ar[i];
			if (flagSwap) {
				if (a > b && !flagExtra) {
					flagReverse = true;
					bi = i;
				}
				else if (ar[ai] > b && !flagReverse){
					bi = i;
					flagExtra = true;
				}
				else {
					break;
				}
			}
			else if (a > b) {
				flagSorted = false;
				ai = i - 1;
				bi = i;
				flagSwap = true;
			}
		}

		if (flagSorted) {
			System.out.print("yes");
			return;
		}
		else if (flagReverse) {
			for (int i = 0; i <= (bi - ai)/2; i++) {
				int a = ar[ai + i];
				int b = ar[bi - i];
				ar[ai + i] = b;
				ar[bi - i] = a;
			}
			boolean flagCheck = true;
			for (int i = 1; i < N; i++) {
				if (ar[i-1] > ar[i]) {
					flagCheck = false;
				}
			}
			if (flagCheck) {
				System.out.println("yes");
				System.out.print("reverse " + (ai + 1) + " " + (bi + 1) );
				return;
			}
			else {
				System.out.println("no");
			}
		}
		else {
			int a = ar[ai];
			int b = ar[bi];
			ar[bi] = a;
			ar[ai] = b;
			boolean flagCheck = true;
			for (int i = 1; i < N; i++) {
				if (ar[i-1] > ar[i]) {
					flagCheck = false;
				}
			}
			if (flagCheck) {
				System.out.println("yes");
				System.out.print("swap " + (ai + 1) + " " + (bi + 1) );
			}
			else
				System.out.println("no");
		}
	}
}
