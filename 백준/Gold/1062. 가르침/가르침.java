

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] alpha = new boolean[26];
    static int n,k;
    static String[] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new String[n];
        alpha['a'- 'a'] = true; //a
        alpha['c' -'a'] = true;
        alpha['i' -'a'] = true;
        alpha['n' -'a'] = true;
        alpha['t' -'a'] = true;
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            temp = temp.replace("anti", "");
            temp = temp.replace("tica", "");
            arr[i] = temp;
        }
        if(k < 5) {
            System.out.println("0");
            return;
        }else if(k == 26) {
            System.out.println(n);
            return;
        }

        solve(0, 0);
        System.out.println(max);

    }
    public static void solve(int a, int len) {
        if(len == k-5) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                boolean check = true;
                for (int j = 0; j < arr[i].length(); j++) {
                    if(!alpha[arr[i].charAt(j) - 'a']) {
                        check = false;
                        break;
                    }
                }
                if(check) cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }


        for (int i = a; i < 26; i++) {
            if(alpha[i] == false) {
                alpha[i] = true;
                solve(i, len + 1);
                alpha[i] = false;
            }
        }
    }
}
