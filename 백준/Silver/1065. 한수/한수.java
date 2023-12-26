

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        if(n < 100) {
            System.out.println(n);
            System.exit(0);
        }else {
           cnt = 99;

            for (int i = 100; i <= n; i++) {
                int hun = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if((hun - ten) == (ten - one)) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);


    }

}
