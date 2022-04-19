package Algo0419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 숫자를 제외한 문자가 연속된 문자열이여야 한다.
 * 
 * 존재하면 1 아니면 0
 * 
*/

public class Main_bj_16171_나는친구가적다 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		//숫자를 제외한다.
		str = str.replaceAll("[0-9]", "");
		st = new StringTokenizer(br.readLine());
		String temp = st.nextToken(); //비교 문자열
		boolean flag = false;
		for(int i=0; i<=str.length()-temp.length(); i++) {
			//해당 길이만큼 자른 게 비교 문자열과 같으면 true 리턴
			if(str.substring(i,i+temp.length()).equals(temp)) {
				flag = true;
			}
		}
		System.out.println(flag? 1: 0);
	}

}
