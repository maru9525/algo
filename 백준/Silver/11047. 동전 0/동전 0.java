

import java.util.*;

public class Main {
    static int n,k;
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int temp = 0;
        for (int i = n-1; i >= 0; i--) {
            if(arr[i] > k) {
                continue;
            }
            temp += (k / arr[i]);
            k = k % arr[i];
        }
        System.out.println(temp);
    }

}
