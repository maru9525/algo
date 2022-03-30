package Algo0330;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1 : 익음
 * 0 : 익지 않음
 * -1 : 토마토가 없음
*/
public class Main_bj_7576_토마토 {
	static class Pair{
		int x;
		int y;
		int cnt;
		public Pair(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	static int M,N;
	static int[][] box;
	static int[] dx = {0,0,-1,1}; //상하좌우
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력 끝
		for(int i=0; i<N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 1) {
					bfs(i,j);
				}
			}
		}
	}

	private static void bfs(int i, int j) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(i,j,0));
		int pcnt = 0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int px = p.x;
			int py = p.y;
			pcnt = p.cnt;
			
			for (int d = 0; d < 4; d++) {
				int nx = px + dx[d];
				int ny = py + dy[d];
				
				if(nx >=0 && nx<N && ny >=0 && ny<M) {
					if(box[nx][ny] == 0) {
						box[nx][ny] = 1;
						q.offer(new Pair(nx,ny,pcnt+1));
					}
				}
			}
		}
		if(check()) {
			System.out.print(pcnt);
		}else {
			System.out.println(-1);
		}
		
	}

	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 0) return false;
			}
		}
		return true;
	}

}
