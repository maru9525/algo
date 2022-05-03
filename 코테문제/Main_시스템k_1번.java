package Algo0503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_kb데이타시스템_1번 {
	static int[] num = {13,18,19,21,28,-1,-2,-4};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		int cnt = 0;
		int d = 3;
		int k = 2;
		for(int i=0; i<num.length; i++) {
			list.add(num[i]);
		}
//		for(int l : list) {
//			System.out.println(l);
//		}
		System.out.println();
		for(int i=1; i<num.length-1; i++) {
			System.out.println(Math.abs(num[i] - num[i+1]));
			if(Math.abs(num[i] - num[i+1]) <= d && cnt <= k) {
				cnt++;
				list.remove(i-1);
				continue;
			}else {
				cnt = 0;
			}
		}
//		for(int l : list) {
//			System.out.println(l);
//		}
	}	

}
