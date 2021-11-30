package Algo1130;

import java.util.Scanner;

public class Main_bj_2231_분해합 {
	/*
	 * 216 = 198
	 * 0부터 시작해서 1,000,000까지해서 
	 * 해당 수 더하기 각 자리의 수를 했을 때 N이 나오면 해당 값 출력
	 * 안나오면 0을 출력한다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0; 
		for (int i = 0; i < N; i++) {
			int M = i;
			int sum = 0;//각 자리수의 합
			while(M !=0 ) { //각 자리수 구함
				sum += M %10;
				M/=10;
			}
			if(sum + i == N) {
				result = i;
				break;
			}
			
		}
		System.out.println(result);
		sc.close();
	}

}
