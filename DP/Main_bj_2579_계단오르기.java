package Algo0424;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_2579_계단오르기 {
	static int n;
	static int[] stair;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		stair = new int[n+1];
		dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = stair[1];
		
		if(n >= 2) {
			dp[2] = stair[1] + stair[2];
		}
		//두 계단 전의 경우와 직전 계단을 밟고 그이전에는 두 계단 이전의 경우(N-3)에서 연속되지 않는 위치인 
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + stair[i-1]) + stair[i];
		}
		
		System.out.println(dp[n]);
	}

}
