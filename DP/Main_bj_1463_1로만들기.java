package Algo0323;

import java.util.Scanner;

public class Main_bj_1463_1로만들기 {
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		dp = new int[N+1];
		dp[0] = dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + 1;
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		System.out.println(dp[N]);
		
	}
}
