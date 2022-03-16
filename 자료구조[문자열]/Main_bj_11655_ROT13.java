package Algo0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_11655_ROT13 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] res = new char[str.length()];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			res[i] = str.charAt(i);
			if(str.charAt(i)>='A' && str.charAt(i)<= 'Z') { //대문자
				if(str.charAt(i) >= 'N') res[i] -= 13;
				else res[i] += 13;
			}else if(str.charAt(i)>=97 && str.charAt(i) <123) { //소문자
				if(str.charAt(i) >= 'n') res[i] -= 13;
				else res[i] += 13;
			}
		}
		for(char c : res) sb.append(c);
		System.out.println(sb.toString());
		
	}

}
