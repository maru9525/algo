import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] a;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[1001];
        a[1] = 1;
        a[2] = 2;
        if(n <= 2) {
            System.out.println(n);
            return;
        }
        for (int i = 3; i <= n; i++) {
            a[i] = (a[i-2] + a[i-1]) % 10007;
        }
        System.out.println(a[n]);

    }

}
