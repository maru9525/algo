package Algo0210;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_bj_1032_명령프롬프트 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		for (int i = 0; i < str[0].length(); i++) {
			boolean check = false;
			for (int j = 0; j < N-1; j++) {
				if(str[j].charAt(i) != str[j+1].charAt(i)) {
					check = true;
					break;
				}
			}
			if(check) System.out.print("?");
			else System.out.print(str[0].charAt(i));
		}
		
	}

}
