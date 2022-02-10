package Algo0210;

import java.util.Scanner;

/*
 * 시작은 0부터
 * 0을 1로 바꾸고 1이면 0으로 바꾼다
 * x += x
 * k번 반복
*/

public class Main_bj_18222_투에모스문자열 {
	static long[] str;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long k = sc.nextLong();
		str = new long[64];
		for (int i = 0; i < str.length; i++) {
			str[i] = (long)Math.pow(2, i);
		}
		System.out.println(solve(k));
	}

	private static int solve(long k) {
		if(k==1) return 0;
		long N = 0;
		
		for (int i = 0; i < str.length; i++) {
			if(k > str[i]) N = str[i];
			else break;
		}
		return 1-solve(k-N);
	}

}
