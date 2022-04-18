package Algo0418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_6603_로또 {
	static int k;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			arr = new int[k];
			visited = new boolean[k];
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			System.out.println();
		}
	}
	private static void dfs(int depth, int start) {
		if(depth == 6) {
			for(int i=0; i<k; i++) {
				if(visited[i]) {
					System.out.print(arr[i]+ " ");
				}
			}
			System.out.println();
		}
		for (int i = start; i < k; i++) {
			visited[i] = true;
			dfs(depth + 1, i+1);
			visited[i] = false;
		}
		
	}

}
