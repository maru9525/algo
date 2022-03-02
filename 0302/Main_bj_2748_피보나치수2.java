package Algo0302;

import java.util.Scanner;

public class Main_bj_2748_피보나치수2 {
	static long[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new long[N + 1];
		
		for (int i = 0; i < N+1; i++) {
			dp[i] = -1;
		}
		dp[0] = 0;
		dp[1] = 1;
		System.out.println(fibo(N));
	}

	private static long fibo(int n) {

		if(dp[n] == -1) {
			dp[n] = fibo(n-1) + fibo(n-2);
		}
		return dp[n];
	}
}
