import java.io.*;
import java.util.*;

public class Main {


    static int a,b,c,d;
    static int[] arr;
    static int aa,bb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int n = a * d + b * c;
        int m = b * d;
        int num = find(n,m);
//        System.out.println(num);
        n /= num;
        m /= num;
        System.out.println(n + " " + m);

    }

    public static int find(int a, int b) {
//        System.out.println("a : " +  a);
//        System.out.println("b : " +  b);
        if(a <= b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if(b == 0) {
            return a;
        }
        return find(b, a % b);
    }

}