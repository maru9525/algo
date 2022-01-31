package Algo0131;
import java.util.*;
import java.io.*;
/*
 * ax + by = c
 * dx + ey = f
 * 의 연립방정식에서 (x,y)의 값을 구하여라
 * a와 d의 최소공배수를 구한다.
 * 최소공배수를 만들 값 temp1 , temp2를 각각 저장한 후.
 * a,b,c * temp1 / e,d,f * temp2
 * 그다음 두개를 뺀다. 빼고 남은 by = c 의 값으로 y의 값을 구한다.
*/
public class Main_bj_19532_수학은비대면강의입니다 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		for (int i = -999; i < 1000; i++) {
			for (int j = -999; j < 1000; j++) {
				if(a*i+b*j==c && d*i+e*j==f) {
					System.out.println(i + " " + j);
					System.exit(0);
				}
			}
		}
	}

}
