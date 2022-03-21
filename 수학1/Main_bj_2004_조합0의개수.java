package Algo0321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2004_조합0의개수 {
	static int fcnt = 0;
	static int scnt = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		fcnt = five(n) - five((n-m)) - five(m);
		scnt = sec(n) - sec((n-m)) - sec(m);
		
		int cnt = Math.min(fcnt, scnt);
		System.out.println(cnt);
		
	}

	private static int sec(long n) {
		int cnt =0;
		while(n >= 2) {
			cnt += n/2;
			n /= 2;
		}
		return cnt;
	}

	private static int five(long n) {
		int cnt = 0;
		while(n >= 5) {
			cnt += n/5;
			n /= 5;
		}
		return cnt;
	}

}
