package Algo0308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_bj_1874_스택수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int check = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			// 입력 받은 숫자가 check보다 작을 경우 같을 때 까지 push
			if (check < num) {
				for (int j = check + 1; j <= num; j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				// check를 num 값으로
				check = num;
				// 젤 위에 값이 num이랑 다를 경우 NO 출력
			} else if (stack.peek() != num) {
				System.out.print("NO");
				return;
			}
			// 그 외는 POP한다.
			stack.pop();
			sb.append("-").append("\n");
		}
		System.out.println(sb.toString());
	}

}
