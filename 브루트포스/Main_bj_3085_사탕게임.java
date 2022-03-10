package Algo0310;
/*
 * i j 
*/
import java.io.*;
import java.util.*;
public class Main_bj_3085_사탕게임 {
	static int N;
	static char[][] board;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = str.charAt(j); //입력
			}
		}
		//행 교환
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				char temp = board[i][j];
				board[i][j] = board[i][j+1];
				board[i][j+1] = temp;
				//카운터 체크
				check(board);
				//원상복구
				temp = board[i][j]; 
				board[i][j] = board[i][j+1];
				board[i][j+1] = temp;
			}
		}
		//열 교환
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				char temp = board[j][i];
				board[j][i] = board[j+1][i];
				board[j+1][i] = temp;
				
				check(board);
				
				temp = board[j][i];
				board[j][i] = board[j+1][i];
				board[j+1][i] = temp;
			}
		}
		System.out.println(max);
	}

	//길이 체크
	
	private static void check(char[][] b) {
		//행 체크
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N-1; j++) {
				if(b[i][j] == b[i][j+1]) {
					cnt++;
				}else {
					cnt = 1;
				}
				max = Math.max(max, cnt);
			}
		}
		//열 체크
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N-1; j++) {
				if(b[j][i] == b[j+1][i]) {
					cnt++;
				}else {
					cnt = 1;
				}
				max = Math.max(max, cnt);
			}
		}
	}

}
