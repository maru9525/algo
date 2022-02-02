package Algo0202;

import java.util.*;
import java.io.*;
/*
 * 입력 : 깁밥의 개수 N, 꼬다리의 길이 K, 김밥조각의 최소 개수 M
 * 		 김밥의 길이 L이 N개 주어짐
 * 출력 : 김밥조각의 길이 P를 최대로 할 때, P 출력. P가 없는 경우 -1 출력
 * 양쪽에서 균일하게 K의 길이만큼 잘라낸다.김밥의 길이가 2K보다 짧으면 한쪽만 자른다. 김밥 길이가 K이거나 그보다 짧으면 그 김밥은 버림
 * 손질된 김밥을 모두 P로 잘라 Pcm김밥으로 만듬. Pcm로 자른 최소 M개 김밥 조각을 만들어야함.
 * P를 최대한 길게 하고 싶을 떄 P의 값은?
 * 
 * 3가지의 경우 1. K보다 짧거나 같다.(버림). 2. 2K보다 짧다 = 한쪽만. 3. 나머지 = K만큼 양쪽에서 자른다.
*/

public class Main_bj_18113_그르다김가놈 {
	static int N, K, M;
	static int Ncnt;
	static int[] gimbap;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int gimbap = Integer.parseInt(br.readLine());
			if (gimbap > (2 * K))
				list.add(gimbap-(2*K));
			if (gimbap < 2 * K && gimbap > K) // K보다 크지만 2K 보다 작을 때
				list.add(gimbap - K); // K만큼 자른다
		}
		int start = 1, end = 1000000000;
		int ans = -1;
		while(start <= end) {
			int mid = (start+end) / 2;
			int cnt = calc(list, mid);
			if(cnt >= M) {
				ans = mid;
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		System.out.print(ans);
	}
	private static int calc(List<Integer> list, int mid) {
		int sum = 0;
		for(int l : list) {
			sum += (l/mid);
		}
		return sum;
	}

}

