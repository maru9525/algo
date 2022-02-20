package Algo0220;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_2160_그림비교 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N개의 그림
		//5*7이 N개
		//첫번째부터 끝까지. 2번째부터 끝까지 비교
		char[][][] map = new char[N][5][7];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				String a = br.readLine();
				for(int k=0; k<7; k++) {
					map[i][j][k] = a.charAt(k);
				}
			}
		}
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		int a = 0, b=0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				cnt = 0;
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 7; l++) {
						if(map[i][k][l] != map[j][k][l]) {
							cnt++;
						}
					}
				}
				if(cnt < min) {
					min = cnt;
					a = i+1;
					b = j+1;
				}
			}
		}
		System.out.println(a + " " + b);
	}

}
