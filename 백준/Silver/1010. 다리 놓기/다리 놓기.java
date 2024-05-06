

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int t;
    static int n,m;
    static int[][] arr = new int[31][31];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            System.out.println(combi(m,n));
        }
    }
    static int combi(int a, int b) {
        if(arr[a][b] > 0 ) {
            return arr[a][b];
        }

        if(a == b || b == 0 ) {
            return arr[a][b] = 1;
        }

        return arr[a][b] = combi(a-1, b-1) + combi(a-1, b);
    }

}
