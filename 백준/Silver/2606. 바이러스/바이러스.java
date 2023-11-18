
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M; //컴퓨터 수, 연결 수
	static int[][] graph;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[N+1][N+1];
		visited = new boolean[101];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph[v1][v2] = graph[v2][v1] = 1;
		}
		bfs(1); // 1부터 시작
		System.out.println(cnt);
	}
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 1; i <= N; i++) {
				if(graph[temp][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
	}

}
