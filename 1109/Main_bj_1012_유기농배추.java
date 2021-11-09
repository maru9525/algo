package Algo1109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_1012_유기농배추 {
	static int T; //테스트케이스
	static int M,N,K; //가로, 세로, 개수
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			visited = new boolean[M][N];
			cnt= 0;
//			Arrays.fill(map, 0);
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				map[m][n] = 1;
			}
//			for(int[] m : map) System.out.println(Arrays.toString(m));
//			System.out.println();
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
	private static void dfs(int i, int j) {
		visited[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(nx >= 0 && nx < M && ny>=0 && ny<N) {
				if(map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
	}

}
