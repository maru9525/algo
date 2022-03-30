package Algo0330;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	1 : 이동할수 있음
	0 : 이동할 수 없음
	1,1 에서 N,M으로 이동해야 할 때 최소의 칸 수
 */
public class Main_bj_2178_미로탐색 {
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
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws Exception {
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
		}//입력
		bfs(0,0);
		
		
	}

	private static void bfs(int i, int j) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(i,j,0));
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int px = p.x;
			int py = p.y;
			int pcnt = p.cnt;
			
			if(px==N-1 && py ==M-1) {
				System.out.println(pcnt+1);
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = px + dx[d];
				int ny = py + dy[d];
				if(nx >=0 && nx < N && ny >= 0 && ny < M) {
					if(map[nx][ny] ==1 && !visited[nx][ny]) {
						q.offer(new Pair(nx,ny,pcnt+1));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}

}
