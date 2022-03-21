package Algo03119;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_6588_골드바흐의추측 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] check = new boolean[1000001];
		StringBuilder sb = new StringBuilder();
		//값 초기화
		for (int i = 2; i < 1000000; i++) {
			check[i] = true;
		}
		//에라토스테네스의 체로 소수 판별
		for(int i=2; i<=1000000; i++) {
			for (int j = i * 2; j <= 1000000; j+=i) {
				if(!check[j]) continue;
				check[j] = false;
			}
		}
		//b-a가 가장 큰 수 를 찾는다.
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			boolean c = false;
			for (int i = 2; i <= n/2; i++) {
				if(check[i] && check[n-i]) {
					sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append("\n");
					c = true;
					break;
				}
			}
			if(!c)
				sb.append("Goldbach's conjecture is wrong.");
		}
		
		System.out.println(sb.toString());
	}

}
