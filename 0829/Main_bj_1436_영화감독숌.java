package Algo0829;

import java.util.Scanner;

public class Main_bj_1436_영화감독숌 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		int num = 666;
		int cnt = 1;
		//숫자 중 6이 3개 들어간 수에서 N번째인 수를 출력
		while(cnt < N) {
			num++;
			//값 중  666이라는 수가 있으면 cnt++
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		System.out.println(num);
		
	}

}
