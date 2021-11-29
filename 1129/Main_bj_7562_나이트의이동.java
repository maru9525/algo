package Algo1129;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_bj_7562_나이트의이동 {
	static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int N;
	static int result = 0;
	static int startX, startY;
	static int endX, endY;
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			visited = new boolean[N][N];
			map = new int[N][N];
			startX = sc.nextInt();
			startY = sc.nextInt();
			endX = sc.nextInt();
			endY = sc.nextInt();

			bfs(startX, startY, 0);
			
			System.out.println(result);
		}
		sc.close();
	}

	private static void bfs(int x1, int y1, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x1, y1, c));
		visited[x1][y1] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == endX && p.y == endY) {
				result = p.cnt;
				break;
			}

			for (int d = 0; d < 8; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				int count = p.cnt + 1;
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					q.offer(new Point(nx, ny, count));
					visited[nx][ny] = true;
				}
			}
		}
	}

}
