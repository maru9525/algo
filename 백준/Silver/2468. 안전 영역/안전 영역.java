

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int cnt;
    static int maxHeight = Integer.MIN_VALUE;
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                maxHeight = Math.max(maxHeight, num);
            }
        }


        for (int i = maxHeight ; i > 0; i--) {
            cnt = 0;
            check(i);
            bfs(i);
            max = Math.max(max, cnt);
        }
        if(max == 0) {
            System.out.println(1);
        }else {

            System.out.println(max);
        }

    }

    static void check(int height) {
        visited = new boolean[n][n];
        //maxHeight 보다 작은 수는 전부다 true 로 변경
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] <= height) {
                    visited[i][j] = true;
                }
            }
        }

    }
    static void bfs(int height) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] > height && !visited[i][j]) {
                    Queue<Pair> q = new LinkedList<>();
                    q.offer(new Pair(i,j));
                    visited[i][j] = true;
                    while(!q.isEmpty()) {
                        Pair p = q.poll();
                        int px = p.x;
                        int py = p.y;
                        for (int d = 0; d < 4; d++) {
                            int di = px + dx[d];
                            int dj = py + dy[d];
                            if(di >= 0 && di < n && dj >=0 && dj < n){
                                if(!visited[di][dj]) {
                                    q.offer(new Pair(di, dj));
                                    visited[di][dj] = true;

                                }
                            }
                        }
                    }
                    cnt++;

                }
            }
        }
    }

}
