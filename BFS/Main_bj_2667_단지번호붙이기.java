package Algo0326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_bj_2667_단지번호붙이기 {
	static int N;
	static int aNum = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1}; //상하좌우
	static int[] dy = {-1,1,0,0};
	static int[] aparts = new int[25*25];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] ==1 && !visited[i][j]) {
					aNum++;
					bfs(i,j);
				}
			}
		}
		Arrays.sort(aparts);
		System.out.println(aNum);
		for (int i = 0; i < aparts.length; i++) {
			if(aparts[i] == 0) continue;
			else System.out.println(aparts[i]);
		}
//		for(int[] m : map) System.out.println(Arrays.toString(m));
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new Pair(x,y));
		aparts[aNum]++;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int px = p.x;
			int py = p.y;
			
			for (int d = 0; d < 4; d++) {
				int nx = px + dx[d];
				int ny = py + dy[d];
				if(nx >= 0 && nx < N && ny >=0 && ny < N) {
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						q.offer(new Pair(nx, ny));
						visited[nx][ny] = true;
						aparts[aNum]++;
					}
				}
			}
		}
	}
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
