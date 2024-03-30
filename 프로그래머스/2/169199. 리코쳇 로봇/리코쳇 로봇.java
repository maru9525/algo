import java.util.*;

class Solution {
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static char[][] map;
    static int[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    static int answer;
    public int solution(String[] board) {
        answer = -1;
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        visited = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 'R') {
                    bfs(i,j);
                }
            }
        }
        
        return answer;
    }
    
    public static void bfs(int i, int j) {
        visited[i][j] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i,j));
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int px = p.x;
            int py = p.y;
            
            if(map[px][py] == 'G') {
                answer = visited[px][py] - 1;
                break;
            }
            for(int d=0; d<4; d++) {
                int pdx = px + dx[d];
                int pdy = py + dy[d];
                while(true) {
                    if(pdx >= 0 & pdx < n && pdy >= 0 && pdy < m 
                       && map[pdx][pdy] != 'D') 
                    {
                        pdx += dx[d];
                        pdy += dy[d];
                    }else {
                        pdx -= dx[d];
                        pdy -= dy[d];
                        break;
                    }
                }
                if(visited[pdx][pdy] == 0 ) {
                    q.offer(new Pair(pdx, pdy));
                    visited[pdx][pdy] = visited[px][py] + 1;
                }
                
            }
        }
        
    }
}