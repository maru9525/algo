package Algo0215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 5개의 숫자 중 3개의 최소 공배수를 구하여라
*/

class Main_bj_1145_적어도대부분의배수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[5];
		int result = 1;
		int cnt = 0;
		
		for(int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		while(true) {
			for(int i=0; i<5; i++) {
				if(result % arr[i] == 0) {
					cnt++;
				}
			}
			if(cnt >= 3) {
				System.out.println(result);
				break;
			}
			cnt = 0;
			result++;
		}
	}

}
