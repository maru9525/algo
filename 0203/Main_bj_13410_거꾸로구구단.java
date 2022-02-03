package Algo0203;

import java.util.*;
import java.io.*;
/*
 * N에서 K항까지의 숫자를 거꾸로 뒤집어 낸다.
 * 그 숫자들을 저장해서 그중 가장 큰 수를 출력한다.
*/

public class Main_bj_13410_거꾸로구구단 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=K; i++) {
			int res =N*i;
			String str = String.valueOf(res);
			String temp = "";
			for(int j=str.length()-1; j>=0 ; j--) {
				temp += str.charAt(j);
			}
			max = Math.max(max, Integer.parseInt(temp));
		}
		System.out.print(max);
	}

}
