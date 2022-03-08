package Algo0308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_bj_9012_괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<>(); // 스택 리셋
			String str = br.readLine();
			boolean check = false;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					stack.push('(');
				} else if (stack.isEmpty()) {
					check = true;
					break;
				} else {
					stack.pop(); // 비어 있지 않으면 pop
				}
			}
			
			if (check == true || !stack.isEmpty()) {
				sb.append("NO");
				sb.append("\n");
			} else {
				sb.append("YES");
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());

	}

}
