package Algo0118;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 순열 문제
*/

public class Main_bj_10819_차이를최대로 {
	static int[] arr;
	static int[] tarr;
	static int N;
	static int max = Integer.MIN_VALUE;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		tarr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		dfs(0);
		System.out.print(max);
		
	
	}
	public static void dfs(int cnt) {
		if(cnt == N) {
			int sum = 0;
			for(int i=0; i<N-1; i++) {
				sum += Math.abs(tarr[i] - tarr[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}
		for(int i=0; i<N; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			tarr[cnt] = arr[i];
			dfs(cnt+1);
			visited[i] = false;
		}
	}

}
