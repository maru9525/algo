import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String result = "";
        String str = sc.next();
        int[] alpha = new int[26];
        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i)-'A']++;
        }

        int odd = 0;
        int num = 0;
        for (int i = 0; i < 26; i++) {
            if(alpha[i] %  2 != 0 ) {
                odd++;
                num = i;
            }
            if(odd >= 2) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char)(i + 'A'));
            }
        }
        result += sb.toString();
        if(odd == 1) {
            result += (char)(num + 'A');
        }
        result += sb.reverse().toString();

        System.out.println(result);

    }

}
