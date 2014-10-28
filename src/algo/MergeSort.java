package algo;

import java.util.Random;

public class MergeSort {
	
	public void MergeSortMethod(int [] a, int lo, int hi) {
		if (lo >= hi) return;
		//We can use Insertion sort for small size of array
		//eg. 10-20 to improve the performance in recursion.
		int mid = (hi - lo) / 2 + lo;
		MergeSortMethod(a, lo, mid);
		MergeSortMethod(a, mid + 1, hi);
		merge(a, lo, mid, hi);
		return;
	}
	
	private void merge(int[] a, int lo, int mid, int hi) {
		int[] temp = new int[hi - lo + 1];
		for (int i = 0; i < hi - lo + 1; i++) {
			temp[i] = a[lo + i];
		}
		
		int ii = lo, jj = mid + 1;
		for (int i = 0; i < hi - lo + 1; i++) {
			if (ii > mid) a[i + lo] = temp[jj++ - lo];
			else if (jj > hi) a[i + lo] = temp[ii++ - lo];
			else {
				if (temp[ii - lo] > temp[jj - lo]) {
					a[i + lo] = temp[jj++ - lo];
				}
				else {
					a[i + lo] = temp[ii++ - lo];
				}
			}
		}
	}
	
	
	/**
	 * To verify that array is sorted or n
	 * @param a array to verify
	 * @return true if sorted else false;
	 */
	public boolean checkSorted(int[] a) {
		int N = a.length;
		for (int i = 0; i < N - 1; i++) {
			if (a[i] > a[i + 1])
				return false;
		}
		return true;
	}
	
	public static void main(String [] args) {
		MergeSort ms = new MergeSort();
		int N = 1000000;
		int[] ar = new int[N];
		Random rm = new Random();
		for (int i = 0; i < N; i++) {
			ar[i] = rm.nextInt(i + 1);
		}
		ms.MergeSortMethod(ar, 0, N - 1);
		System.out.println(ms.checkSorted(ar));
	}
}
