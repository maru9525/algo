package Algo0419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_bj_1107_리모컨_2 {
	static int N;
	static int M;
	static boolean[] button;
	static int res = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		button = new boolean[10];
		for(int i=0; i<M; i++) {
			int a = Integer.parseInt(st.nextToken());
			button[a] = true;
		}
		
		solve();
		System.out.println(res);
		
		
	}
	private static void solve() {
		res = Math.abs(N-100);
		for(int i=0; i<=999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean broken = false;
			for (int j = 0; j < len; j++) {
				if(button[str.charAt(j)-'0']) {
					broken = true;
					break;
				}
			}
			
			
			if(!broken) {
				int min = Math.abs(N-i) + len;
				res = Math.min(res, min);
			}
		}
	}

}
