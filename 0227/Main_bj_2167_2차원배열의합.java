package Algo0226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2167_2차원배열의합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} //입력
		int K = Integer.parseInt(br.readLine()); //k 값
		for (int t = 0; t < K; t++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int i= Integer.parseInt(st.nextToken());
			int j= Integer.parseInt(st.nextToken());
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			for (int l = i; l <= x; l++) {
				for (int k = j; k <= y; k++) {
					sum += arr[l][k];
				}
			}
			System.out.println(sum);
		}
	}

}
