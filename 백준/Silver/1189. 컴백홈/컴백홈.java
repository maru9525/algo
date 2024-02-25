

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r,c,k;
    static char[][] map;
    static boolean[][] visited;
    static int answer = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        visited[r-1][0] = true;
        dfs(r-1, 0,1);

        System.out.println(answer);
    }
    static void dfs(int sx, int sy, int cnt) {

        if(sx == 0 && sy == c-1) {
            if(cnt == k) {
                answer++;
                return;
            }
        }
        for (int d = 0; d < 4; d++) {
            int px = sx + dx[d];
            int py = sy + dy[d];
            if(px >= 0 && px < r && py >= 0 && py < c && !visited[px][py] && map[px][py] != 'T') {
                visited[px][py] = true;
                dfs(px, py,  cnt+ 1);
                visited[px][py] = false;
            }
        }



    }

}
