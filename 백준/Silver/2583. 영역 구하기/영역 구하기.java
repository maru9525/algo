
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,k;
    static int[][] map;
    static boolean[][] visited;
    //입력된 좌표 색칠
    //색칠한 거 제외하고 4방 탐색 -> 없으면 멈추고 해당 넓이 결과 배열에 셋팅
    //오름차순으로 출력
    static int[] result;
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int cnt;
    static int rcnt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];
        result = new int[m*n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    visited[y][x] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(i,j);
                }
            }
        }

        Arrays.sort(result);

        System.out.println(rcnt);
        for (int r :
                result) {
            if(r != 0 ) {

                System.out.print(r + " ");
            }
        }
    }
    public static void bfs(int a, int b) {
        int startX = a;
        int startY = b;
        Queue<Pair> q = new LinkedList<>();
        visited[startX][startY] = true;
        cnt = 1;
        q.offer(new Pair(startX, startY));
        while (!q.isEmpty()) {

            Pair p = q.poll();
            int px = p.x;
            int py = p.y;
            for (int d = 0; d < 4; d++) {
                int pdx = px + dx[d];
                int pdy = py + dy[d];
                if(pdx>=0 && pdx<m && pdy >=0 && pdy<n  && !visited[pdx][pdy]) {
                    cnt++;
                    visited[pdx][pdy] = true;
                    q.offer(new Pair(pdx,pdy));
                }
            }
        }
        result[rcnt++] = cnt;
    }

}
