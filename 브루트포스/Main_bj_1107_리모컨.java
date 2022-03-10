package Algo0311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 100번 부터 시작하고 이동할려는 채널로 갈려면 버튼을 몇번 눌러야 하는가?
*/
public class Main_bj_1107_리모컨 {
	static int N,M;
	static boolean[] button;
	static int res;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		button = new boolean[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());
			button[x] = true;
		}
		//입력 끝
		check(100);
		System.out.println(res);
	}
	private static void check(int s) {
		res = Math.abs(N-s); //초기값
		for (int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i); //숫자를 문자열로 바꿈.
			int len = str.length();
			
			boolean broken = false;
			for (int j = 0; j < len; j++) {
				if(button[str.charAt(j) - '0']) { //고장난거 체크 
					broken = true; //고장 체크
					break;
				}
			}
			//고장 안났으면
			//해당 값을 누른후 N까지 이동하는 횟수  N-i
			if(!broken) {
				int min = Math.abs(N-i) + len; 
				res = Math.min(min, res);
			}
		}
	}

}
