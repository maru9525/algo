package Algo0121;
/*
	뱀이면 내려가고 
	사다리면 올라간다.
	1에서 시작해 100 칸으로 이동한다.
	map 은 10*10
*/
import java.util.*;
import java.io.*;
public class Main_bj_16928_뱀과사다리게임 {
	static int N,M;
	static int[] cnt = new int[101];
	static int[] ladderAndSnake = new int[101];
	static boolean[] visited = new boolean[101];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i< N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			ladderAndSnake[u] = v;
		}
		bfs();
	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		cnt[1] = 0;
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == 100) {
				System.out.print(cnt[cur]);
				return;
			}
			for(int i=1; i<7; i++) {
				int x = cur + i;
				if(100<x) continue;
				if(visited[x]) continue;
				visited[x] = true;
				
				if(ladderAndSnake[x] !=0) {
					if(!visited[ladderAndSnake[x]]) {
						q.offer(ladderAndSnake[x]);
						visited[ladderAndSnake[x]] = true;
						cnt[ladderAndSnake[x]] = cnt[cur] + 1;
					}
				}else {
					q.offer(x);
					cnt[x] = cnt[cur] + 1;
//					System.out.println("cnt"+  x  + " " + cnt[x]);
				}
			}
			
		}
	}
	

}
