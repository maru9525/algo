package Algo0827;

import java.util.Scanner;

public class Main_bj_1085_직사각형에서탈출 {
	static int x,y,w,h;
	static int a,b,c,d; //가장 가까운 거리 값
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
			
		a = Math.abs(x-0);
		b = Math.abs(y-0);
		c = Math.abs(x-w);
		d = Math.abs(y-h);
		
		int[] arr = new int[4];
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		arr[3] = d;
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			min = Math.min(arr[i], min);
		}
		
		System.out.println(min);
	}

}
