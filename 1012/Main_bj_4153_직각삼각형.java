package Algo1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_4153_직각삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] check = new int[3];
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				check[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(check);
			
			if(check[0]==0 &&check[1]==0 && check[2]==0) System.exit(0);
			
			if(Math.pow(check[2], 2) == Math.pow(check[1], 2) + Math.pow(check[0], 2)) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
		}
	}

}
