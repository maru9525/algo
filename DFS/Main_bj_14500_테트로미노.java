package Algo0420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_14500_테트로미노 {
	static int N,M;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int res;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i,j,1,map[i][j]);
				visited[i][j] = false;
				check(i,j);
			}
		}
		System.out.println(res);
	}

	private static void check(int x, int y) {
		if(x<N-2 && y<M-1) {
			res = Math.max(res, map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y+1]);
		}
		if(x<N-2 && y>0) {
			res = Math.max(res, map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y-1]);
		}
		if(x<N-1 && y<M-2)
			res = Math.max(res, map[x][y] + map[x][y+1] + map[x][y+2] + map[x+1][y+1]);
		if(x>0 && y<M-2)
			res  = Math.max(res, map[x][y] + map[x][y+1] + map[x][y+2] + map[x-1][y+1]);
	}

	private static void dfs(int x, int y, int cnt, int sum) {
		if(cnt >= 4) {
			res = Math.max(res, sum);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx >=0 && nx < N && ny >=0 && ny<M) {
				if(!visited[nx][ny]) {
					
					visited[nx][ny] = true;
					dfs(nx,ny, cnt+1, sum + map[nx][ny]);
					visited[nx][ny] = false;
				}
			}
		}
	}

}
