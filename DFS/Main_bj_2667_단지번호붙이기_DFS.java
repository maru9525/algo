package Algo0326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_bj_2667_단지번호붙이기_DFS{
	static int N;
	static int[][] arr;
	static int cnt;
	static int[] dx = {-1, 1, 0 ,0}; //상하좌우
	static int[] dy = {0, 0, -1, 1};
	
	static ArrayList<Integer> result;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j)- '0';
			}
		}
//		for(int[] a : arr) System.out.println(Arrays.toString(a));
		cnt = 0;
		result = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					cnt=1;
					dfs(i,j);
					result.add(cnt);
				}
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(int r : result) System.out.println(r);
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny< N) {
				if(arr[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx,ny);
					cnt++;
				}
			}
		}
		
	}

}
