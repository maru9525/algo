/**
* 메모리: 18504 KB, 시간: 160 ms
* 2021.11.24
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int[] visited = new int[100001];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(N));
	}

	private static int bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		int start = n;
		int num = 0;
		visited[start] = 1;
		while(!q.isEmpty()) {
			num = q.poll();
			
			if(num == K) {
				return visited[num]-1;
			}
			//x-1 : num-1이 0보다 크고 num-1을 방문하지 않았을 때
			//num-1번째는 현재 위치의 +1 값.
			if(num-1 >=0 && visited[num-1] == 0) {
				visited[num-1] = visited[num] + 1;
				q.add(num-1);
			}
			//x+1
			if(num+1 <=100000 && visited[num+1] == 0) {
				visited[num+1] = visited[num]+1;
				q.add(num+1);
			}
			//x*2
			if(2*num <=100000 && visited[2*num] == 0) {
				visited[2*num] = visited[num] + 1;
				q.add(2*num);
			}
		}
		return -1;
	}

}
