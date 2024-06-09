

import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        if(perm()) {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
        }else {
            sb.append(-1);
        }

        System.out.println(sb.toString());
    }

    static boolean perm() {
        int i = arr.length - 1;
        while(i > 0 && arr[i] > arr[i-1]) {
            i--;
        }
        if(i == 0) {
            return false;
        }
        int j = arr.length - 1;
        while(arr[i-1] < arr[j]) {
            j--;
        }

        swap(i-1, j);
        j = arr.length - 1;
        while(i < j) {
            swap(i,j);
            i++;
            j--;
        }
        return true;
    }

    public static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }




}
