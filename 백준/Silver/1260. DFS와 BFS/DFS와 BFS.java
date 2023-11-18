
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main{
	static int N,M,V;
	static int[][] graph;
	static boolean[] visited = new boolean[1001];
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		M = Integer.parseInt(st.nextToken()); //간선의 개수
		V = Integer.parseInt(st.nextToken()); //시작 정점 번호
		graph= new int[N+1][N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph[v1][v2] = graph[v2][v1] = 1;
			
		}
		dfs(V);
		sb.append("\n");
		Arrays.fill(visited, false);
		
		bfs(V);
		System.out.println(sb);
		sb.setLength(0);
		Arrays.fill(visited, false);
	}

	private static void bfs(int v) {
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			sb.append(temp).append(" ");
			for (int i = 1; i <= N; i++) {
				if(graph[temp][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		q.clear();
	}

	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");
		
		for (int i = 1; i <= N; i++) {
			if(graph[v][i] == 1 && visited[i]== false) {
				dfs(i);
			}
		}
		
	}


}
