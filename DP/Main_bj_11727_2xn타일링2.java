package Algo0323;

import java.util.Scanner;

public class Main_bj_11727_2xn타일링2 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[1001]; //1~1000
		dp[1] = 1;
		dp[2] = 3;
		//dp[2]의 형태에서 2*1 세로 형태 + dp[1] 형태의 2*1 가로 2개 or 2*2 형태 
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + (dp[i-2]*2))%10007;
		}
		System.out.println(dp[n]);
		
		sc.close();
	}

}
