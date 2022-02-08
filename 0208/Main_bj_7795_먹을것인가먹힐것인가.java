package Algo0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_bj_7795_먹을것인가먹힐것인가 {
	static int A,B;
	static int[] N;
	static int[] M;
	static int result;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			N = new int[A];
			M = new int[B];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < A; i++) {
				N[i] =Integer.parseInt(st.nextToken()); 
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < B; i++) {
				M[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(M);
			check();
			System.out.println(result);
		}
	}

	private static void check() {
		result = 0;
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < B; j++) {
				if(N[i]  > M[j]) {
					result++;
				}
			}
		}
	}

}
