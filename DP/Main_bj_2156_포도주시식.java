package Algo0424;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_2156_포도주시식 {
	static int n;
	static int[] p;
	static int[] dp;
	static int max = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		p = new int[n+1];
		dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(br.readLine());
		}//입력 끝
		dp[1] = p[1];
		
		if(n>=2) {
			dp[2] = p[1] + p[2];
		}
		//마지막 수를 선택하지 않아도 된다는 규칙이 있는 경우
		//이전 값까지의 합을 모두 구해주면 된다. 
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + p[i], dp[i-3] + p[i-1] + p[i]));
		}
		
		System.out.println(dp[n]);
	}
	private static void solve(int cnt) {
		if(cnt == 3) {
			
			cnt = 0;
		}
	}

}
