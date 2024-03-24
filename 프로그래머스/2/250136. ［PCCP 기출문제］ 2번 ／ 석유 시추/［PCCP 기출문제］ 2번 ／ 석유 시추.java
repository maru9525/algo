import java.util.*;
class Solution {
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        } 
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1}; //상하좌우
    static int max = Integer.MIN_VALUE;
    static boolean[][] visited;
    static int[] oil;
    static int n,m;
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        oil = new int[m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j, land);    
                }
                
            }
        }
        
        for(int i=0; i<m; i++) {
            max = Math.max(max, oil[i]);
        }
        // answer = Arrays.stream(oil).max().getAsInt();
        // System.out.println(answer);
        return max;
    }
    
    public static void bfs(int i, int j, int[][] land) {
        visited[i][j] = true;
        Queue<Pair> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(new Pair(i,j));
        int cnt = 1;
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            set.add(p.y);
            int px = p.x;
            int py = p.y;
            for(int d=0; d<4; d++){
                int pdx = px + dx[d];
                int pdy = py + dy[d];
                if(pdx >= 0 && pdx < n && pdy >= 0 && pdy < m) {
                    if(!visited[pdx][pdy] && land[pdx][pdy] == 1) {
                        visited[pdx][pdy] = true;
                        q.offer(new Pair(pdx, pdy));
                        cnt++;
                    }
                }
            }
        }
        for(int idx : set) {
            oil[idx] += cnt;
        }
    }
}