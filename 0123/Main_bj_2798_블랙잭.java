package Algo0123;
import java.util.*;
import java.io.*;
public class Main_bj_2798_블랙잭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int result = 0;
		for(int i=0; i<N-2; i++) {
			for(int j = i+1; j<N-1; j++) {
				for(int k = j+1; k<N; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if(sum == M) {
						result = sum;
						break;
					}
					if(result < sum && sum < M) {
						System.out.println(result);
						result = sum;
					}
				}
			}
		}
		System.out.print(result);
	}

}
