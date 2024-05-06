

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L,C;
    static char[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
//        for(char a : arr) System.out.print(a);

        combi(0,0,0,0);

    }
    static void combi(int start, int depth, int ja, int mo) {
        if(depth == L && ja >=2 && mo >= 1) {
            for(int i=0; i<C; i++) {
                if(visited[i]) {
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
        }

        for(int i=start; i<C; i++) {
            visited[i] = true;
            combi(i+1, depth + 1, ja + (!check(arr[i]) ? 1 : 0), mo + (!check(arr[i]) ? 0 : 1));
            visited[i] = false;
        }
    }

    static boolean check(char a) {
        if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a =='u')
            return true;
        else
            return false;
    }


}
