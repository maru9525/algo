package Algo0423;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_14391_종이조각 {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int res = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
//		for(int[] m : map) System.out.println(Arrays.toString(m));
		dfs(0,0);
		System.out.println(res);
	}

	private static void dfs(int x, int y) {
		if(x >= N) {
			check();
			return;
		}
		
		if(y >= M) {
			dfs(x+1, 0);
			return;
		}
		visited[x][y] = true;
		dfs(x, y+1);
		
		visited[x][y] = false;
		dfs(x, y+1);
	}

	private static void check() {
		//가로
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < M; j++) {
				if(visited[i][j]) {
					temp *= 10;
					temp += map[i][j];
				}else {
					sum += temp;
					temp = 0; 
				}
			}
			sum += temp;
		}
		
		//세로
		for (int i = 0; i < M; i++) {
			int temp = 0;
			for (int j = 0; j < N; j++) {
				if(!visited[j][i]) {
					temp *= 10;
					temp += map[j][i];
				}else {
					sum += temp;
					temp = 0;
				}
			}
			sum += temp;
		}
		res = Math.max(res, sum);
	}

}
