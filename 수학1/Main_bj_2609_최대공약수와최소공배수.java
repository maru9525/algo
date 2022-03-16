package Algo0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int gcd = gcd(a,b);
		int lcd = a*b / gcd;
		System.out.println(gcd);
		System.out.println(lcd);
		
	}

	private static int gcd(int a, int b) {
		while(b!=0) {
			int mod = a % b;
			a = b;
			b = mod;
		}
		return a;
	}

}
