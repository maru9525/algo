package Algo0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	8*8 로 잘라야 하고 거기서 B와W가 반복적으로 형성되어있지 않으면 안된다.
*/
public class Main_bj_1018_체스판다시칠하기 {
	static int N, M;
	static char[][] chess;
	static boolean[][] check;
	static int cnt;
	static int min = 64;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chess = new char[N][M];
		check = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j =0; j < M; j++) {
				chess[i][j] = str.charAt(j);
				if(chess[i][j] == 'W') {
					check[i][j] = true;
				}else {
					check[i][j] = false;
				}
			}
		}
//		for(char[] c : chess) System.out.println(c);
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				change(i,j);
			}
		}
		System.out.println(min);
		
	}

	private static void change(int x, int y) {
		int a = x+8;
		int b = y+8;
		
		boolean color = check[x][y];
		for (int i = x; i < a; i++) {
			for (int j = y; j < b; j++) {
				if(check[i][j] != color) cnt++;
				
				if(color == true) color = false;
				else if(color == false) color = true;
			}
			if(color == true) color = false;
			else if(color == false) color = true;
		}
		cnt = Math.min(cnt, 64-cnt);
		min = Math.min(min, cnt);
	}

}
