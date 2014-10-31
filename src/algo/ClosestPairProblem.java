package algo;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


public class ClosestPairProblem {

	private double distance;
	private Point p1;
	private Point p2;
	private class Point {
		public int x;
		public int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public double distanceTo(Point that) {
			int diffX = this.x - that.x;
			int diffY = this.y - that.y;
			return Math.sqrt((double)diffX * diffX + (double)diffY * diffY);
		}
		
		@Override
		public String toString() {
			return "x: " + this.x + " y: " + this.y; 
		}
	}
	
	public class PointByX implements Comparator<Point> {
		public int compare(Point a, Point b) {
			if (a.x < b.x) return -1;
			else if (a.x > b.x) return 1;
			else {
				if (a.y < b.y) return -1;
				else if (a.y > b.y) return 1;
				else return 0;
			}
		}
//		public int compare(Point a, Point b) {
//			Termmap.get(a);
//			TermTexta = hasmap(a);
//			TermTextb = hasmap(b);
//			if (a > b) return 1;
//			else if (a < b) return -1;
//		}	
	}
	
	private class PointByY implements Comparator<Point> {
		public int compare(Point a, Point b) {
			if (a.y < b.y) return -1;
			else if (a.y > b.y) return 1;
			else {
				if (a.x < b.x) return -1;
				else if (a.x > b.x) return 1;
				else return 0;
			}
		}
	}
	
	public void closestPair(Point[] p){
		Point[] pX = p;
		Point[] pY = pX.clone();
		PointByX pXSort = new PointByX();
		PointByY pYSort = new PointByY();
		Arrays.sort(pX, pXSort);
		Arrays.sort(pY, pYSort);
		int lo = 0, hi = pX.length;
		distance = Double.MAX_VALUE;
		Point[] aux = new Point[hi];
		closestPairRec(pX, pY, aux, lo, hi - 1);
	}
	
	private double closestPairRec(Point[] pX, Point[] pY, Point[] aux, int lo, int hi) {
		
		if (lo >= hi) return Double.POSITIVE_INFINITY;
		int mid = (lo + hi) / 2;
		double delta1, delta2;
		closestPairSplit(pY, aux, lo, mid, hi);
		delta1 = closestPairRec(pX, pY, aux, lo, mid);
		delta2 = closestPairRec(pX, pY, aux, mid + 1, hi);
		closestPairMerge(pY, aux, lo, mid, hi);
		double delta = Math.min(delta1, delta2);
		int M = 0;
		for (int i = lo; i <= hi; i++) {
			if (pY[i].x < delta)
				aux[M++] = pY[i];
		}
		for (int i = 0; i < M - 1; i++) {
			for (int j = i + 1; j < M && j < i + 7 + 1; j++) {
				if (aux[j].y - aux[i].y < delta){
					double dis = aux[j].distanceTo(aux[i]);
					if (dis < delta) {
						delta = dis;
						if (dis < distance) {
							distance = dis;
							p1 = aux[i];
							p2 = aux[j];
						}
					}
				}
			}
		}
		return delta;
	}
	
	private void closestPairSplit(Point[] pY, Point[] aux, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = pY[i];
		}
		int ii = lo, jj = mid + 1;
		for (int i = lo; i <= hi; i++) {
			if (ii > mid) pY[i] = aux[jj++];
			else if (jj > hi) pY[i] = aux[ii++];
			else {
				if (aux[ii].x < aux[mid].x)
					pY[i] = aux[ii++];
				else 
					pY[i] = aux[jj++];
			}
		}
	}
	
	private void closestPairMerge(Point[] pY, Point[] aux, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = pY[i];
		}
		int ii = lo, jj = mid + 1;
		for (int i = lo; i <= hi; i++) {
			if (ii > mid) pY[i] = aux[jj++];
			else if (jj > hi) pY[i] = aux[ii++];
			else {
				if (aux[ii].x < aux[jj].x) {
					pY[i] = aux[ii++];
				}
				else {
					pY[i] = aux[jj++];
				}
					
			}
		}
	}
	public static void main (String[] args) {
		int n = 10;
		Point[] p = new Point[n];
		ClosestPairProblem cpp = new ClosestPairProblem();
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			int x = r.nextInt(10);
			int y = r.nextInt(10);
			p[i] = 	cpp.new Point(x, y);
			System.out.print("[i : " + i + " x : " + x + " y : " + y + " ]");
		}
//		Arrays.sort(p, cpp.new PointByX());
		cpp.closestPair(p);
		System.out.println("Point p1 : " + cpp.p1.toString());
		System.out.println("Point p2 : " + cpp.p2.toString());
		System.out.println("min Distance : " + cpp.distance);
	}
}
