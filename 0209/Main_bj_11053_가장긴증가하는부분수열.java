package Algo0208;

import java.util.Scanner;

public class Main_bj_11053_가장긴증가하는부분수열 {
	static int N;
	static int[] A;
	static int[] dp;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		dp[0] = 1;
		for (int i = 1; i < N; i++) {
			LIS(i);
		}
		for(int d: dp) {
			max = Math.max(max, d);
		}
		System.out.print(max);
		sc.close();
		
	}
	public static void LIS(int N) {
		dp[N] = 1;
		for (int i = 0; i < N; i++) {
			if(A[i] < A[N] && dp[N] <=dp[i]) {
				dp[N] = dp[i] + 1;
			}
		}
	}

}
