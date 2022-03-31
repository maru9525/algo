package Algo0331;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_11724_연결요소의개수 {
	static int N,M;
	static int[][] graph;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		
		visited = new boolean[N+1];
		int cnt = 0;
		for (int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	private static void dfs(int start) {
		visited[start] = true;
		for (int i = 1; i < N+1; i++) {
			if(graph[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

}
