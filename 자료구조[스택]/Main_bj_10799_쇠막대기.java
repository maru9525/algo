package Algo0314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_bj_10799_쇠막대기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		int res = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)== '(') {
				stack.push('(');
			}else if(str.charAt(i)== ')') {
				stack.pop();
				if(str.charAt(i-1) == '(') {
					res += stack.size();
				}else {
					res++;
				}
			}
		}
		System.out.println(res);
	}

}
