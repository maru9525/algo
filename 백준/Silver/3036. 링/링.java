

import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n ; i++) {
            int num = gcd(arr[0], arr[i]);
            System.out.println(arr[0] / num + "/" + arr[i]/num);
        }

    }
    static int gcd(int a, int b) {
        int temp = 0;

        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}
