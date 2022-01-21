package Algo0121;

import java.util.*;
import java.io.*;

public class Main_bj_10546_배부른마라토너 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			if (map.get(temp) == null) {
				map.put(temp, 1);
			} else {
				map.put(temp, map.get(temp) + 1);
			}
		}
		for (int i = 0; i < N - 1; i++) {
			String temp = sc.next();
			map.put(temp, map.get(temp) - 1);
		}

		for (String t : map.keySet()) {
			if (map.get(t) != 0) {
				System.out.print(t);
				break;
			}
		}

	}

}
