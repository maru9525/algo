package Algo0422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
/*
 * 숫자는 0~9의 숫자이고 중복은 x
 * 부등호를 제외한 숫자에서 최대값과 최소값을 구하라
*/
public class Main_bj_2529_부등호 {
	static int k;
	static String str;
	static char[] giho;
	static boolean[] visited;
	static ArrayList<String> result = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		str = br.readLine().replaceAll(" ", ""); //공백 제거
		giho = new char[k];
		visited = new boolean[10];
//		System.out.println(str); 
		//부등호를 뽑아낸다.
		for(int i=0; i<str.length(); i++) {
			giho[i] = str.charAt(i);
		} //부등호 저장
		dfs(0, "");
		Collections.sort(result);
		
		System.out.println(result.get(result.size()-1));
		System.out.println(result.get(0));
		
	}
	private static void dfs(int depth, String num) {
		if(depth == k+1) {
			result.add(num);
			return;
		}
		for (int i = 0; i < 10; i++) {
			if(depth == 0 || !visited[i] && compare(num.charAt(num.length()-1)- '0',i,giho[depth-1])) {
				visited[i] = true;
				dfs(depth + 1, num + String.valueOf(i));
				visited[i] = false;
			}
		}
		
	}
	private static boolean compare(int a, int b, char c) {
		if(c == '<') return a < b;
		else return a > b;
	}	

}
