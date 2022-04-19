package Algo0419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_bj_2644_촌수계산 {
	static int n;
	static int p1,p2;
	static int m;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int res = -1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i=1; i<n+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjList[x].add(y);
			adjList[y].add(x);
		}
		
		dfs(p1,p2,0);
		System.out.println(res);
		
	}
	private static void dfs(int start, int end, int cnt) {
		if(start == end) {
			res = cnt;
			return;
		}
		visited[start] = true;
		for(int i=0; i<adjList[start].size(); i++) {
			int next = adjList[start].get(i);
			if(!visited[next]) {
				dfs(next, end, cnt+1);
			}
		}
	}

}
