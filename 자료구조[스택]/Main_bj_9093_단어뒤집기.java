package Algo0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main_bj_9093_단어뒤집기 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine()); 
		Stack stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			String str = sc.nextLine();
			
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == ' ') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(" ");
				}else {
					stack.push(str.charAt(j));
				}
			}
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
	}

}
