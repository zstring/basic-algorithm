package algo.TCSRM.Srm637;

public class GreaterGameDiv2 {

	public int calc(int[] sn, int[] so) {
		int N = sn.length;
		int count = 0;
		for (int  i = 0; i < N; i++) {
			if (sn[i] > so[i])
				count++;
		}
		return count;
	}
}
