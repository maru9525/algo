

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        int cost;

        public Pair(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }
    static int n;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int INF = 10000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        while(true) {
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            sb.append("Problem ").append(cnt++).append(": ");
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(dijkstra(arr, n)).append("\n");

        }

        System.out.println(sb.toString());
    }

    private static int dijkstra(int[][] arr, int n) {
        Queue<Pair> q = new PriorityQueue<>();
        int[][] move = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(move[i], INF);
        }
        q.add(new Pair(0,0, arr[0][0]));
        move[0][0] = arr[0][0];

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int px = p.x;
            int py = p.y;
            int pcost = p.cost;

            if(px == n-1 && py == n-1) {
                return pcost;
            }

            for (int d = 0; d < 4; d++) {
                int pdx = px + dx[d];
                int pdy = py + dy[d];
                if(pdx<0 || pdx>n-1 || pdy<0 || pdy>n-1) continue;

                if(pcost+arr[pdy][pdx] < move[pdy][pdx]) {
                    move[pdy][pdx] =pcost+arr[pdy][pdx];
                    q.add(new Pair(pdx,pdy,pcost+arr[pdy][pdx]));
                }
            }

        }
        return -1;
    }


}
