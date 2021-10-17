package Algo1017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_1920_수찾기2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		int[] charr = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			charr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			System.out.println(binarySearch(arr, charr[i]));
		}
		
	}

	private static int binarySearch(int[] arr, int i) {
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
		
		while(low<=high){
			mid = (low + high) / 2;
			if(arr[mid] == i) return 1;
			else if(arr[mid] > i) high = mid-1;
			else if(arr[mid] < i) low = mid+1;
		}
		return 0;
	}

}
