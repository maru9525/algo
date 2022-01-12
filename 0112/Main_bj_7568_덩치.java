package Algo0111;

import java.util.Scanner;

public class Main_bj_7568_덩치 {
	static int[][] man;
	static int[] rank;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		rank = new int[N];
		man = new int[N][2]; // [][0] = 몸무게, [][1]=키
		for (int i = 0; i < N; i++) {
			man[i][0] = sc.nextInt();
			man[i][1] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (man[i][0] < man[j][0] && man[i][1] < man[j][1]) {
					rank[i]++;
				}
			}
		}
		for (int r : rank)
			System.out.print((r + 1) + " ");
		sc.close();
	}

}
