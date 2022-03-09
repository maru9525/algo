package Algo0309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_bj_1406_에디터_스택 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String comm = br.readLine();
		StringBuilder sb = new StringBuilder();

		Stack<Character> lstack = new Stack<>();
		Stack<Character> rstack = new Stack<>();
		for (int i = 0; i < comm.length(); i++) {
			lstack.push(comm.charAt(i)); // 왼쪽 스택에 첫 명령어 입력
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			char t = temp.charAt(0);

			if (t == 'P') {
				char t2 = temp.charAt(2);
				lstack.push(t2);
			} else if (t == 'L') {
				if (!lstack.isEmpty())
					rstack.push(lstack.pop());
			} else if (t == 'D') {
				if (!rstack.isEmpty())
					lstack.push(rstack.pop());
			} else if (t == 'B') {
				if (!lstack.isEmpty())
					lstack.pop();
			}
		}
		while (!lstack.isEmpty()) {
			rstack.push(lstack.pop());
		}
		while (!rstack.isEmpty()) {
			sb.append(rstack.pop());
		}
		System.out.print(sb.toString());
	}

}
