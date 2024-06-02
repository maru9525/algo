

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;
    static int[] sortArr;

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        sortArr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sortArr[i] = sc.nextInt();
        }
        Arrays.sort(sortArr);

        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 0;
        for(int s : sortArr) {
            if(!map.containsKey(s)) {
                map.put(s, num);
                num++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int a :
                arr) {
            int number = map.get(a);
            sb.append(number).append(" ");
        }
        System.out.println(sb.toString());
    }



}
