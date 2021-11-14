package Algo1114;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_7569_토마토 {
	static int M,N; 
	static int[][] map;
	static int[] dx = {-1, 1, 0 ,0};
	static int[] dy = {0, 0, -1 ,1};
	static Queue<Pair> q;
	static class Pair{
		int x;
		int y;
		int cnt;
		public Pair(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		q = new LinkedList<Pair>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.add(new Pair(i,j,0));
				}
			}
		}
		bfs();
	}

	private static void bfs() {
		int ncnt = 0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int ni = p.x;
			int nj = p.y;
			ncnt = p.cnt;
			
			for (int d = 0; d < 4; d++) {
				int nx = ni + dx[d];
				int ny = nj + dy[d];
				if(nx < 0 || nx >= N || ny < 0 ||ny >= M) {
					continue;
				}
				if(map[nx][ny] != 0) {
					continue;
				}
				map[nx][ny] = 1;
				q.add(new Pair(nx, ny, ncnt + 1));
			}
		}
		if(check()) {
			System.out.println(ncnt);
		}else {
			System.out.println(-1);
		}
	}
	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	

}
