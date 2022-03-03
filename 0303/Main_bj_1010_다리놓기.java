package Algo0303;

import java.util.Scanner;

public class Main_bj_1010_다리놓기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			double N = sc.nextDouble();
			double M = sc.nextDouble();
			
			System.out.printf("%.0f\n",combi(M,N));
			//조합 mCn
		}
	}

	private static double combi(double m, double n) {
		double a = 1;
		double b = 1;
		
		for (double i = m; i > m-n; i--) {
			a = a * i;
		}
		for (double i = n; i > 0 ; i--) {
			b = b * i;
		}
		return a/b;
	}

}
