import java.util.*;
class Solution {
    static int[][] graph;

    
  
    public int solution(int n, int[][] wires) {
        int answer = n;
         graph = new int[n+1][n+1];
        //연결
        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            graph[a][b] = graph[b][a] = 1;
        }
        
        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            //선 끊기
            graph[a][b] = graph[b][a] = 0;
            
            answer = Math.min(answer, bfs(n, a));
            //선 연결
            graph[a][b] = graph[b][a] = 1;
            
        }
        
        
        
        return answer;
    }
    static int bfs(int n, int start) {
        int[] visited = new int[n+1];
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()) {
            int p = q.poll();
            visited[p] = 1;
            
            for(int i = 1; i<=n; i++) {
                if(visited[i] == 1) continue;
                if(graph[p][i] == 1) {
                    q.offer(i);
                    cnt++;
                }
            }
        }
        return (int)Math.abs(n-2*cnt);
        
    }
    
    
}