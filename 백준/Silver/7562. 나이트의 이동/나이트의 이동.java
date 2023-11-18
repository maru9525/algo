import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
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
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int sx, sy; //시작점
	static int ex, ey; //도착점
	static int[] dx = {-2,-1,1,2,2,1,-1,-2}; //체스 이동방향
	static int[] dy = {-1,-2,-2,-1,1,2,2,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			//시작점과 도착점
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			
			bfs(sx, sy);
		}
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
			
			if(px == ex && py == ey) {
				System.out.println(pcnt);
				break;
			}
			for (int d = 0; d < 8; d++) {
				int nx = px + dx[d];
				int ny = py + dy[d];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Pair(nx,ny, pcnt+1));
					}
				}
			}
			
		}
	}

}
