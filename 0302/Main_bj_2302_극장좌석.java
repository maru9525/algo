package Algo0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_2302_극장좌석 {
	static int N,M;
	static int[] check;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		check = new int[N+1];
		check[0] = 1;
		check[1] = 1;
		check[2] = 2;
		for (int i = 3; i <= N; i++) {
			check[i] = check[i-1] + check[i-2];
		}
		int result = 1;
		int prev = 0;
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(br.readLine());
			result *= check[temp - prev - 1];
			prev = temp;
		}
		//마지막 vip 좌석 다음 좌석에서 끝 좌석까지의 경우의 수
		result *= check[N-prev]; 
		
		System.out.println(result);
	}

}
