package Algo1111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_2178_미로탐색 {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int endX;
	static int endY;
	static int cnt;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		endX = N-1;
		endY = M-1;
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
//		for(int[] m: map) System.out.println(Arrays.toString(m));
		visited[0][0] = true;
		bfs(0,0);
		System.out.println(map[endX][endY]);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int ni = n[0];
			int nj = n[1];
			
			for (int d = 0; d < 4; d++) {
				int nx = ni + dx[d];
				int ny = nj + dy[d];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				if(visited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}
				q.add(new int[] {nx, ny});
				map[nx][ny] = map[ni][nj] + 1;
				visited[nx][ny] = true;
			}
		}
	}

}
