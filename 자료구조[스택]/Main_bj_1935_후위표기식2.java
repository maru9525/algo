package Algo0315;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_bj_1935_후위표기식2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String str = br.readLine();
		Stack<Double> stack = new Stack<>();
		for(int i=0; i<N; i++) { //숫자 값 입력
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)-'A' >= 0 && str.charAt(i)-'A' <26) {
				stack.push((double) arr[str.charAt(i)-'A']);
			}else {
				double d1 = stack.pop();
				double d2 = stack.pop();
				double res = 0;
				switch(str.charAt(i)) {
				case '+':
					res = d2 + d1;
					break;
				case '-':
					res = d2 - d1;
					break;
				case '*':
					res = d2 * d1;
					break;
				case '/':
					res = d2 / d1;
					break;
				}
				stack.push(res);
			}
		}
		System.out.printf("%.2f", stack.pop());
	}

}
