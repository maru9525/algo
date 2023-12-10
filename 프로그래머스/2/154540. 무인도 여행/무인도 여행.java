import java.util.*;
class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0}; //상하좌우
    static boolean[][] visited;
    static char[][] map;
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
    static int cnt;
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        int check = 0;
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0;i<maps.length;i++){
            map[i] = maps[i].toCharArray();
        }
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j] != 'X' && !visited[i][j]) {
                    answer.add(bfs(i,j));
                }else {
                    continue;
                }
            }
        }
        if(answer.size() == 0){
            answer.add(-1);
        }
        Collections.sort(answer);
        // System.out.print(answer.size());
        for(int t: answer) System.out.print(t);
        
        int[] temp = new int[answer.size()];
        // int 
        for(int i=0; i< answer.size(); i++) {
            temp[i] = answer.get(i);
        }
        return temp;
    }
    public static int bfs(int x, int y) {
        visited[x][y] = true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x,y));
        int sum = 0;
        while(!q.isEmpty()) {
           
            Pair p = q.poll();
            int px = p.x;
            int py = p.y;
            sum += map[px][py] - '0';
            for(int d=0; d<4; d++) {
                int pdx = px + dx[d];
                int pdy = py + dy[d];
                if(pdx >= 0 && pdx < map.length && pdy >= 0 && pdy < map[0].length){
                    if(map[pdx][pdy] != 'X' && !visited[pdx][pdy]) {
                        visited[pdx][pdy] = true;

                        q.offer(new Pair(pdx, pdy));
                    }
                }
            }
        }
        return sum;
        
    }
}