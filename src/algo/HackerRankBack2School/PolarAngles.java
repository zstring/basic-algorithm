package algo.HackerRankBack2School;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PolarAngles {
	
	public class Point {
		int x;
		int y;
		double degree;
		public Point (int x, int y){
			this.x = x;
			this.y = y;
			if (y == 0 && x >= 0) this.degree = 0;
			else if (x == 0 && y >= 0) this.degree = 90;
			else if (x < 0 && y == 0) this.degree = 180;
			else if (x == 0 && y < 0) this.degree = 270;
			else {
				double d = 0.0;;
				if (x < 0 && y > 0) {
					d =Math.toDegrees(Math.atan2(y, x));
//					d = d + 180;
				}
				else if (x < 0 && y < 0) {
					int yy = y * (-1);
					int xx = x * (-1);
					d = Math.toDegrees(Math.atan2(yy, xx )) ;
					d = d  + 180;
				}
				else if (x > 0 && y < 0) {
					d = Math.toDegrees(Math.atan2(y, x)) ;
					d = d + 360;
				}
				else {
					d = Math.toDegrees(Math.atan2(y,x));
				}
				this.degree = d;
			}
		}
		
		public double distaceToOrigin() {
			return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		}
		
		@Override
		public String toString() {
			return x + " " + y;
		}
	}
	
	public class PolarAngle implements Comparator<Point> {
		public int compare(Point a, Point b){
			if (a.degree < b.degree) return -1;
			else if (a.degree > b.degree) return 1;
			else {
				double val =  a.distaceToOrigin() - b.distaceToOrigin();
				if (val < 0) return -1;
				else if (val > 0) return 1;
				else return 0;
			}
		}
	}
	
	public static void main(String[] args) {
		PolarAngles dpFib = new PolarAngles();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Point[] p = new Point[N];
		PolarAngles s = new PolarAngles();
		for (int i= 0;i < N; i++) {
			p[i] = s.new Point(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(p, s.new PolarAngle());
		for (int i = 0; i < N; i++) {
			System.out.println(p[i].toString());
		}
	}
}
