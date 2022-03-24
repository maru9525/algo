package Algo0324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_11055_가장큰증가부분수열 {
	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력
		dp[0] = arr[0]; // 초기값
		for (int i = 1; i < N; i++) {
			LIS(i);
		}
		int max = 0;
		for(int d : dp) {
			max = Math.max(max, d);
		}
		System.out.println(max);
	}

	private static void LIS(int n) {
		dp[n] = arr[n];
		for (int i = 0; i < n; i++) {
			if (arr[i] < arr[n]) {
				dp[n] = Math.max(dp[n], dp[i] + arr[n]);
			}
		}
	}

}
