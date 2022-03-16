package Algo0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1934_최소공배수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int gcd = gcd(a,b);
			int lcd = a*b / gcd;
			System.out.println(lcd);
		}
	}
	public static int gcd(int a, int b) {
		while(a!=0) {
			int mod = b % a;
			b = a;
			a = mod;
		}
		
		return b;
	}

}
