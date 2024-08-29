import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static class Pair{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n,m;
    static int[][] map;
    static int[][] day;
    static int answer = Integer.MIN_VALUE;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        day = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) q.add(new Pair(i,j));
            }
        }
        bfs();
        boolean check = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 0) check = true;
                answer = Math.max(answer, day[i][j]);


            }
        }
        if(check) {
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }

    }
    public static void bfs() {

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int px = p.x;
            int py = p.y;
            for (int d = 0; d < 4; d++) {
                int pdx = px + dx[d];
                int pdy = py + dy[d];
                if(pdx >= 0 && pdx < m && pdy >= 0 && pdy < n && map[pdx][pdy] == 0) {
                    map[pdx][pdy] = 1;
                    day[pdx][pdy] = day[px][py] + 1;
                    q.offer(new Pair(pdx,pdy));
                }
            }
        }


    }
}
