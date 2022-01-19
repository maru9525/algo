package Algo0119;
import java.util.*;
import java.io.*;
public class Main_bj_13565_침투 {
	static int x,y;
	static int[][] map;
	static boolean[][] visited;
	static boolean flag = false;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		map = new int[x][y];
//		visited = new boolean[x][y];
		for(int i=0; i<x; i++) {
			String temp = br.readLine();
			for(int j=0; j<y; j++) {
				map[i][j] = temp.charAt(j) -'0';
			}
		}
		for(int i=0; i<y; i++) {
			if(flag==true) break;
			if(map[0][i] ==0) {
				visited = new boolean[x][y];
				visited[0][i] = true;
				dfs(0,i);
			}
		}
		if(flag==true) {
			System.out.println("YES");
		}else {
			System.out.println("No");
		}
	}
	public static void dfs(int r, int c) {
		if(r==(x-1)) {
			flag = true;
			return;
		}
		for(int d=0; d<4; d++) {
			int nx = r + dx[d];
			int ny = c + dy[d];
			if(nx <0 || nx>=x || ny<0 || ny>=y) continue;
			if(map[nx][ny] == 0 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx,ny);
			}
		}
	}

}
