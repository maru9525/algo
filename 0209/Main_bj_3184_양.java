package Algo0209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 점 : 빈 필드, # : 울타리, o : 양, v: 늑대
 * 상하좌우로 이동이 가능. 울타리를 지나지 않고 다른 칸으로 이동할 수 있다면, 두 칸은 같은 영역 안에 속해 있다고 함.
 * 마당에서 탈출 할 수 있는 칸은 어떤 영역에도 속하지 않는다.
 * 영역 안의 양의 수가 늑대보다 많으면 이기고, 늑대를 우리에서 쫓아낸다.
 * 그렇지 않으면 늑대가 모든 양을 먹는다.
 * 아침에 도달했을 때, 양과 늑대의 수를 출력해라.
 * v 일경우 상하좌우 체크하고 만약 o 일경우 oCnt++
 * .일경우는 걍 패스
 * #은 
*/

public class Main_bj_3184_양 {
	static class Pair{
		private int x,y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1}; //상하좌우
	static int[] dy = {-1,1,0,0};
	static int wolfCnt , sheepCnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != '#' && !visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		System.out.print(sheepCnt +" " + wolfCnt );
		
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x,y));
		visited[x][y] = true;
		int wolf = 0, sheep = 0;
		if(map[x][y] == 'v') wolf++;
		else if(map[x][y] == 'o') sheep++;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if(nx < 0 ||  nx >=R || ny < 0 || ny>=C) continue;
				if(visited[nx][ny]) continue;
				visited[nx][ny] = true;
				if(map[nx][ny] == '#') continue;
				if(map[nx][ny] == 'v') wolf++;
				else if(map[nx][ny] =='o') sheep++;
				q.offer(new Pair(nx,ny));
			}
		}
		if(wolf>= sheep) wolfCnt+=wolf;
		else sheepCnt += sheep;
	}

}
