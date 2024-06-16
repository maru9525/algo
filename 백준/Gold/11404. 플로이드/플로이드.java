

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] graph;

    static int INF = 987654321;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i!=j) graph[i][j] = INF;
            }
        }
//        visited = new boolean[n+1][n+1];
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int c = Integer.parseInt(st.nextToken());
//            if(visited[a][b]) {
//                if(graph[a][b] > c) {
//                    graph[a][b] = c;
//                }
//            }else {
//                graph[a][b] = c;
//                visited[a][b] = true;
//            }
            graph[a][b] = Math.min(graph[a][b], c);

        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        solve();



        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF) {
                    graph[i][j] = 0;
                }

                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }


    }
    public static void solve() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }


    }



}
