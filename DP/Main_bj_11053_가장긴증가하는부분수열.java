package Algo0324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_11053_가장긴증가하는부분수열 {
	static int N;
	static int[] dp;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N];
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} //입력
		dp[0] = 1;
		for (int i = 0; i < N; i++) {
			LIS(i);
		}
		int max = 0;
		for(int d : dp) {
			max = Math.max(max, d);
		}
		System.out.println(max);
	}
	public static void LIS(int n) {
		dp[n] = 1;
		for (int i = 0; i < n; i++) {
			if(arr[i] < arr[n] && dp[i] >= dp[n]) {
				dp[n] = dp[i] + 1;
			}
		}
	}

}
