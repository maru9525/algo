package Algo0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_17103_골드바흐파티션 {
	static boolean[] check;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine()); 
			//소수 체크
			check = new boolean[n+1];
			for (int i = 0; i < n; i++) {
				check[i] = true;
			}
			for (int i = 2; i <= n; i++) {
				for (int j = i * 2; j <= n; j+=i) {
					if(!check[j]) continue;
					check[j] = false;
				}
			}
			int cnt = 0;
			for (int i = 2; i <= n/2; i++) {
				if(check[i] && check[n-i]) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

}
