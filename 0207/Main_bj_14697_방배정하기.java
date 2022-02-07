package Algo0207;
import java.util.*;
import java.io.*;
public class Main_bj_14697_방배정하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int num = sc.nextInt();
		int result = 0;
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				for (int k = 0; k < 50; k++) {
					if((A*i) + (B*j) + (C*k) == num)
						result = 1;
				}
			}
		}
		System.out.print(result);
	}

}
