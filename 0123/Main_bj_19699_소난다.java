package Algo0123;

import java.util.*;
import java.io.*;

public class Main_bj_19699_소난다 {
	static int N, M;
	static int[] cow;
	static boolean[] visited;
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 소의 수
		M = sc.nextInt(); // M 마리의 합
		cow = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			cow[i] = sc.nextInt(); // 입력
		}
		Arrays.sort(cow); // 정렬
		combi(0, 0, 0); //합, 
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		if(list.size() ==0){
			System.out.print(-1);
		}else {
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
		}
	}

	public static void combi(int cnt, int sum, int start) {
		if(cnt==M) {
			if(prime(sum)) {
				set.add(sum);
			}
			return;
		}
		for(int i = start; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combi(cnt+1, sum + cow[i], i+1);
				visited[i] = false;
			}
		}
		
	}

	public static boolean prime(int weight) {
		int i = 0;
		int last = weight / 2;
		if (weight <= 1) {
			return false;
		}
		for (i = 2; i <= last; i++) {
			if ((weight % i) == 0) {
				return false;
			}
		}
		return true;
	}

}
