package Algo1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2805_나무자르기 {
	static int n,m;
	static int[] arr;
	static int max, min = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		while(min < max) {
			int mid = (min+max) / 2;
			long sum = 0;
			for (int i = 0; i < n; i++) {
				int res = arr[i]; //나무의 높이
				
				if(res - mid > 0) { //나무의 높이에서 중간값이 0 이상인경우
					sum += (res - mid); // 합계에 더함
				}
			}
			if(sum < m) {
				max = mid; //자르는 높이가 높아 위치를 낮춘다
			}else {
				min = mid + 1; //자르는 높이가 낮아 위치를 높임
			}
		}
		System.out.println(min - 1);
	}

}
