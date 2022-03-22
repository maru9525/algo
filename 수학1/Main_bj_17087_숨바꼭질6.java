package Algo0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_17087_숨바꼭질6 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N]; //동생 위치
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i] = Math.abs(S-a); //현재 내 위치와 동생위치의 차이를 구하기 위해 절댓값
		}
		//n개 수의 gcd 값을 구함
		int res = arr[0]; //첫번째 수
		for (int i = 1; i < N; i++) {
			res = gcd(res, arr[i]);
		}
		System.out.println(res);
	}

	private static int gcd(int i, int j) {
		while(j != 0) {
			int mod = i % j;
			i = j;
			j = mod;
		}
		return i;
	}

}
