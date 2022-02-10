package Algo0210;

import java.util.Scanner;
/*
 * n의 값이 10 이하이면 
*/

public class Main_bj_1110_더하기사이클 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int temp = N;
		int ten =0, fir= 0; //십의자리수 일의자리수
		int cnt =0;
		
		while(true) {
			if(temp<10) {
				ten = 0;
				fir = temp%10;
			}else {
				ten = temp/10;
				fir = temp%10;
			}
			int left = fir;
			int right = (ten + fir)%10;
			
			temp = (left*10) + right;
			cnt++;
			
			if(temp == N) break;
		}
		System.out.println(cnt);
	}

}
