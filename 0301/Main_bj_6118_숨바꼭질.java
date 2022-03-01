package Algo0301;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_6118_숨바꼭질 {
	static int N, M;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		
		bfs(1);
	}

	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] cnt = new int[N+1];
		boolean[] visited = new boolean[N+1];
		int max = Integer.MIN_VALUE;
		int idx = 0;
		int maxCnt = 0;
		q.offer(i);
		visited[i] = true;
		while(!q.isEmpty()) {
			i = q.poll();
			for(int a : adj[i]) {
				if(!visited[a]) {
					q.offer(a);
					visited[a] = true;
					cnt[a] = cnt[i] + 1;
				}
			}
		}
		for (int j = 0; j <= N; j++) {
			if(cnt[j] > max) {
				max = cnt[j];
				idx = j;
				maxCnt = 1;
			}else if(max == cnt[j]) {
				maxCnt++;
			}
		}
		System.out.println(idx + " " + cnt[idx] + " " + maxCnt);
	}

}
