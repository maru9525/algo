package Algo0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_bj_4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			
			if(str.equals(".")) break;
			
			System.out.println(solve(str));
			
		}
	}

	private static String solve(String str) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '(' || c == '[') {
				stack.push(c);
			}
			
			else if(c == ')') {
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				}else {
					stack.pop();
				}
			}
			else if(c ==']') {
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}else {
					stack.pop();
				}
			}
		}
		if(stack.empty()) {
			return "yes";
		}else {
			return "no";
		}
	}

}
