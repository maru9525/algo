package Algo0217;

import java.util.Scanner;

public class Main_bj_1259_팰린드룸수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		while (true) {
			str = sc.next();
			boolean result = true;
			if (str.equals("0"))
				System.exit(0); // 0이면 멈춤

			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) == str.charAt(str.length() - i - 1)) {
					result  = true;
				} else {
					result = false;
					break;
				}
			}
			if(result) System.out.println("yes");
			else System.out.println("no");

		}
	}

}
