package Algo0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1978_소수찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = N;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			//1일 경우 제외
			if(n==1) cnt--;
			for (int j = 2; j < n; j++) {
				//소수는 자기 자신만으로 나눠지는 수
				if(n % j == 0 ) {
					cnt--; //소수가 아니면 개수를 뺀다.
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}
