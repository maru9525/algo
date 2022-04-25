package Algo0425;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_10844_쉬운계단수_dp {
	static int MOD = 1000000000;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[n+1][10];
		//첫번째 자리수는 오른쪽 맨 끝의 자리수이므로 경우의 갯수가 1개씩임
		for (int i = 1; i <10 ; i++) {
			dp[1][i] = 1; 
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				if(j==0) {
					dp[i][0] = dp[i-1][1] % MOD;
				}
				else if(j==9) {
					dp[i][9] = dp[i-1][8] % MOD;
				}
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
				}
			}
		}
		long result = 0;
		for (int i = 0; i < 10; i++) {
			result += dp[n][i];
		}
		System.out.println(result % MOD);
	}
	
	

}
