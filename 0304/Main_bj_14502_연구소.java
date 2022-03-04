package Algo0304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 완탐
 * bfs, dfs
 * 빈칸에 벽 3개씩 세우고 dfs로 완탐
 * 바이러스 퍼지는거 bfs로 확인
 * 바이러스 4방탐색
 * 안전영역의 최대크기 출력
 *
 */



public class Main_bj_14502_연구소 {
	
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int N,M;
	static int[][] map;
	static int[][] copyMap;
	static int[][] virusMap;
	static int max = Integer.MIN_VALUE;
	
	static int[] dx = {-1,0,1,0}; //상우하좌
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
	//	System.setIn(new FileInputStream("res/input_bj_14502.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //가로
		M = Integer.parseInt(st.nextToken()); //세로
		
		map = new int[N][M];
		copyMap = new int[N][M];
		//입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				 map[i][j] = copyMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0) {
					map[i][j] = 1;
					dfs(1);
					map[i][j] = 0;
				}
			}
		}
		
		System.out.println(max);
		
		
	}

	private static void dfs(int cnt) {
		if(cnt ==3) {
			bfs();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static void bfs() {
		virusMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				virusMap[i][j] = map[i][j];
			}
		}
		
		Queue<Pair> q = new LinkedList<Pair>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(virusMap[i][j] == 2) {
					q.offer(new Pair(i,j));
				}
			}
		}
		
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x= p.x;
			int y = p.y;
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(virusMap[nx][ny] == 0) {
						virusMap[nx][ny] = 2;
						q.offer(new Pair(nx,ny));
					}
				}
			}
		}
		
		int cnt =0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(virusMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt);
		
	}
	
	
	
	

}
