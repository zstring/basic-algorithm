package algo.DPHackerRank;

public class ZigZag {

	public int longestZigZag(int [] se) {
		int size = 1;
		boolean posflag = true;
		boolean negflag = true;
		
		for (int i = 1; i < se.length; i++) {
			if (se[i] - se[i - 1] > 0 && negflag) {
				size++;
				posflag = true;
				negflag = false;
			}
			else if (se[i] - se[i - 1] < 0 && posflag) {
				size++;
				posflag = false;
				negflag = true;
			}
		}
		return size;
	}
}
