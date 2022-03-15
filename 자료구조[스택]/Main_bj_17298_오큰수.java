package Algo0315;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_bj_17298_오큰수 {
	static int N;
	static int[] check;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check = new int[N];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			check[i] =Integer.parseInt(st.nextToken());//배열에 값을 넣는다.
		}
		for(int i=0; i<N; i++) {
			//스택이 비어있지 않거나, check의 peek 인덱스 값이 다음 check 값보다 작을때
			//pop한 인덱스의 check의 값을 해당 인덱스의 value로 바꾼다.
			while(true) {
				if(!stack.isEmpty() && check[stack.peek()] < check[i]) {
					check[stack.pop()] = check[i];
				}
				else break;
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			check[stack.pop()] = -1;
		}
		for(int c : check) {
			sb.append(c).append(" ");
		}
		System.out.println(sb.toString());
	}

}
