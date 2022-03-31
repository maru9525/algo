package Algo0331;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_16929_twodots {
	static int N,M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}//입력 
		
		boolean isCircle = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				boolean check = false;
				if(!visited[i][j]) {
					check = dfs(i,j,-1,-1,map[i][j]);
				}
				if(check) {
					System.out.println("Yes");
					System.exit(0);
				}
			}
		}
		System.out.println("No");
		
	}
	private static boolean dfs(int x, int y, int prev_x, int prev_y, char c) {
		if(visited[x][y]) return true;
		visited[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx >= 0 && nx<N && ny>=0 && ny<M) {
				if((!(nx==prev_x && ny==prev_y)) && map[nx][ny] == c) {
					if(dfs(nx,ny, x,y, c)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
