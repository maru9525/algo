package Algo0325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_bj_14226_이모티콘 {
	static int S;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		visited = new boolean[2001][2001];
		bfs();
	}

	private static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(1,0,0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int snum = p.screen;
			int bnum = p.board;
			int t = p.time;
			
			if(snum == S) {
				System.out.println(t);
				break;
			}
			if(snum > 0 && bnum < 2000) {
				//복사
				if(!visited[snum][snum]) {
					visited[snum][snum] = true;
					q.offer(new Pair(snum, snum, t + 1));
				}
				//삭제
				if(!visited[snum -1][bnum]) {
					visited[snum-1][bnum] = true;
					q.offer(new Pair(snum-1, bnum, t+1));
				}
			}
			if(bnum >0 && snum + bnum < 2000) {
				if(!visited[snum+bnum][bnum]) {
					visited[snum + bnum][bnum] = true;
					q.offer(new Pair(snum + bnum, bnum, t+1 ));
				}
			}
			
			//
		}
	}
	static class Pair {
		int screen;
		int board;
		int time;
		public Pair(int screen, int board, int time) {
			super();
			this.screen = screen;
			this.board = board;
			this.time = time;
		}
		
	}

}
