package Algo1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * N과 K의 최대값은 14
*/

public class Main_bj_2755_부녀회장될테야 {
	static int[][] arr = new int[15][15];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		makeArr();
		
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(arr[k][n]);
		}
	}

	private static void makeArr() {
		for (int i = 0; i < 15; i++) {
			arr[i][1] = 1; //1호는 모두 값이 1이다.
			arr[0][i] = i; //0층 15호까지 값 
		}
		//1층부터 14층 , 2호부터 14호
		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				arr[i][j] = arr[i][j-1] + arr[i-1][j];
			}
		}
	}

}
