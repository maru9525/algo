package Algo0331;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_bj_13023_ABCDE {
	static int N,M;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=0; i<N; i++) {
			visited = new boolean[N]; //새 정점으로 확인하기 위해 초기화
			dfs(i,0);
		}
		System.out.println(0);
	}
	private static void dfs(int x, int len) {
		if(len == 4) {
			System.out.println(1);
			System.exit(0);;
		}
		visited[x] = true;
		for (int i = 0; i < list[x].size(); i++) {
			int temp = list[x].get(i);
			if(!visited[temp]) {
				visited[temp] = true;
				dfs(temp, len + 1);
				visited[temp] = false;
			}
		}
	}

}
