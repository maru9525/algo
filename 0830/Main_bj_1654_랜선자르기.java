package Algo0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_1654_랜선자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long max = arr[k-1];
		long min = 1;
		long middle = 0;
		
		while(max >= min) {
			middle = (max+min)/2;
			
			long cnt = 0;
			for (int i = 0; i < k; i++) {
				cnt += arr[i]/middle;
			}
			
			if(cnt >= n) {
				min = middle + 1;
			}else if(cnt < n) {
				max = middle - 1;
			}
		}
		System.out.println(max);
	}

}
