package Algo0220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_18353_병사배치하기 {
	static int N;
	static int max = Integer.MIN_VALUE;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); //입력
		}
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[j] > arr[i]) { //내림차순
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		for(int d : dp) {
			max = Math.max(max, d);
		}
		System.out.println(N-max);
	}

}
