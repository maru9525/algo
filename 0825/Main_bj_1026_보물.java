package Algo0729;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_bj_1026_보물 {

	public static void main(String[] args) {
//		System.setIn(new FileInputStream(""));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		Integer[] B = new Integer[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
//		for(int a : A) System.out.print(a);
//		System.out.println();
		for (int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
//		Integer[] B = {1,2,3,4,5};
		Arrays.sort(B, Collections.reverseOrder());
//		for(int b : B) System.out.print(b);
		int res = 0;
		for (int i = 0; i < N; i++) {
			res += A[i] * B[i];
		}
		System.out.println(res);
		sc.close();
		
	}

}
