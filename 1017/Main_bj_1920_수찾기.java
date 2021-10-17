package Algo1017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_1920_수찾기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		int[] charr = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			charr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= m ; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if(charr[i] == arr[j]) {
					System.out.println(1);
				}else {
					cnt++;
				}
			}
			if(cnt==5) {
				System.out.println(0);
			}
			
		}
		
	}

}
