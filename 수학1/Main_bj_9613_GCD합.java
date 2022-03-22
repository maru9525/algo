package Algo0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_9613_GCD합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			//수 입력
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); 
			}
			long sum = 0;
			//int 형으로 하면 범위를 벗어나기 때문에 long형으로 선언한다.
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					sum += gcd(arr[i], arr[j]);
				}
			}
			System.out.println(sum);
			
		}
	}

	private static int gcd(int i, int j) {
		while(j !=0 ) {
			int mod = i % j;
			i = j;
			j = mod;
		}
		return i;
	}

}
