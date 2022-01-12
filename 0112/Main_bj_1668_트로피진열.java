package Algo0112;

import java.lang.*;
import java.util.*;
public class Main_bj_1668_트로피진열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i =0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int left = 1, right = 1;
		int leftMax = arr[0];
		for(int i=1; i<N; i++) {
			if(leftMax < arr[i]) {
				leftMax = arr[i];
				left++;
			}
		}
		int rightMax = arr[N-1];
		
		for(int i=N-2; i>=0; i--) {
			if(arr[i] > rightMax) {
				rightMax = arr[i];
				right++;
			}
		}
		System.out.println(left);
		System.out.print(right);
	}

}
