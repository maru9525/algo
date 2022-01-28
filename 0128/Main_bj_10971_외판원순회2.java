package Algo0128;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * N개의 도시를 거쳐 원래의 도시로 온다
 * 최소 비용은 얼마인가?
 * bfs로 방문 체크하고 해당 위치에서 갈 수 있는 최소 값을 가져온다.
 * 그리고 더한다 ?
*/
public class Main_bj_10971_외판원순회2 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min= Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			dfs(i,i,0,0);
		}
		System.out.print(min);
	}
	private static void dfs(int start, int now, int sum, int cnt) {
		if(cnt == N) {
			if(start ==now) {
				min = Math.min(min, sum);
			}
			return;
		}
		for(int i=0; i<N; i++) {
			if(map[now][i] ==0) continue;
			
			if(!visited[i] && map[now][i] != 0) {
				visited[i] = true;
				sum += map[now][i];
				dfs(start, i, sum, cnt+1);
				visited[i] = false;
				sum -= map[now][i];
			}
		}
	}

}
