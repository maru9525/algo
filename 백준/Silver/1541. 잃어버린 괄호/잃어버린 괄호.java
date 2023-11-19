

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int sum = Integer.MAX_VALUE;
        //split 2개가 가능한가
        String[] mtemp = str.split("-");
        for (int i = 0; i < mtemp.length; i++) {
            int temp = 0;
            String[] ptemp = mtemp[i].split("\\+");
            for (int j = 0; j < ptemp.length; j++) {
                temp += Integer.parseInt(ptemp[j]);
            }
            if(sum == Integer.MAX_VALUE) {
                sum = temp;
            }else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
