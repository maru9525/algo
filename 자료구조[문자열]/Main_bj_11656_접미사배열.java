package Algo0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_bj_11656_접미사배열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] sArr = new String[str.length()];
		for(int i=0; i<str.length(); i++) {
			String temp = "";
			for (int j = i; j < sArr.length; j++) {
				temp += str.charAt(j);
			}
			sArr[i] = temp;
		}
		Arrays.sort(sArr);
		for(String s: sArr) System.out.println(s);
	}

}
