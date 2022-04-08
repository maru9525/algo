package Algo0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_4963_섬의개수 {
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1,-1,1,1,-1}; //상하좌우 대각선 
	static int[] dy = {-1,1,0,0,-1,-1,1,1};
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0) System.exit(0);; //0 0 입력시 종료
			map = new int[h][w]; //h : 높이 / w:가로
			visited = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}// 입력 끝
			cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
			
			
			
		}
	}
	private static void bfs(int i, int j) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(i,j));
		visited[i][j] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int px = p.x;
			int py = p.y;
			for (int d = 0; d < 8; d++) {
				int nx = px + dx[d];
				int ny = py + dy[d];
				if(nx>=0 && nx<h && ny>=0 && ny<w) {
					if(map[nx][ny] ==1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Pair(nx, ny));
					}
				}
			}
		}
	}
	static class Pair {
		int x;
		int y; 
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
