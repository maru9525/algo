package Algo0212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_bj_4803_트리 {
	static int[] parents;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = 1;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n == 0 && m == 0) break;
			parents = new int[n+1];
			for (int i = 1; i < n+1; i++) {
				parents[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			Set<Integer> treeSet = new HashSet<>();
			for (int i = 1; i < n+1; i++) {
				int ra = find(i);
				if(ra > 0) treeSet.add(ra);
			}
			
			int treeNum = treeSet.size();
			if(treeNum == 0) sb.append("Case " + tc + ": ").append("No trees. \n");
			else if(treeNum == 1) sb.append("Case " + tc + ": ").append("There is one tree. \n");
			else if(treeNum > 1) sb.append("Case " + tc + ": ").append("A forest of " + treeNum+ " trees.\n");
			tc++;
		}
		System.out.println(sb.toString());
	}

	private static void union(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		if(ry < rx) {
			int tmp = rx;
			rx = ry;
			ry = tmp;
		}
		if(rx == ry) parents[rx] = 0;
		else parents[ry] = rx;
	}

	private static int find(int x) {
		if(parents[x] == x) return x;
		return find(parents[x]);
	}

}
