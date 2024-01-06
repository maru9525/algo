

import java.util.Scanner;

public class Main {
    static int n, k;
    static int[][] map;
    static int val;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        map = new int[n][n];
        val = n * n;
        int r = 0;
        int c = 0;

        StringBuilder sb = new StringBuilder();

        create();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j] + " ");
                if(map[i][j] == k) {
                    r = i + 1;
                    c = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(r + " " + c);
        System.out.println(sb.toString());
    }
    static void create() {
        int curR = n / 2;
        int curC = n / 2;

        int next = 0;
        int count = 0;

        int max = 1;
        int ls = 0;

        for (int i = 1; i <= n * n; i++) {
            map[curR][curC] = i;

            curR +=  dx[next % 4];
            curC += dy[next % 4];
            count++;

            if(count == max) {
                next++;
                count = 0;
                ls++;
            }
            if(ls == 2) {
                max++;
                ls = 0;
            }
        }
    }


}
