package Algo0325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_1697_숨바꼭질 {
	static int N,K;
	static int[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		visited = new int[100001];
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int result = bfs(N);
		System.out.println(result);
	}
	private static int bfs(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(num);
		visited[num] = 1; //시작 위치 1로 초기화
		while(!q.isEmpty()) {
			int temp = q.poll();
			if(temp == K) return visited[temp]-1;
			
			if(temp-1 >= 0 && visited[temp-1] ==0) {
				visited[temp-1] = visited[temp] + 1;
				q.add(temp-1);
			}
			if(temp+1 <= 100000 && visited[temp+1] == 0) {
				visited[temp+1] = visited[temp] + 1;
				q.add(temp+1);
			}
			if(temp*2 <= 100000 && visited[temp*2] ==0) {
				visited[temp*2] = visited[temp] + 1;
				q.add(temp*2);
			}
		}
		return -1;
	}

}
