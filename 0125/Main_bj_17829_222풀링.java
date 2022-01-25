package Algo0125;

import java.util.*;
import java.io.*;

public class Main_bj_17829_222풀링 {
	static int N; 
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		fooling();
		System.out.print(map[0][0]);
		
	}
	static void fooling() {
		if(N==1) {
			return;
		}
		for(int i=0; i<N; i+=2) {
			for(int j=0; j<N; j+=2) {
				int[] temp = {map[i][j], map[i][j+1], map[i+1][j], map[i+1][j+1]};
				Arrays.sort(temp);
				map[i/2][j/2] = temp[2];
			}
		}
		N /= 2;
		fooling();
	}

}
