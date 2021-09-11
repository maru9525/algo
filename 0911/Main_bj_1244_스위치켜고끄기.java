package Algo0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1 : 켜져 있음 / 0 : 꺼져 있음
 * 성별과 받은 수에 따라 스위치를 조작한다
 * 남자 : 자기가 받은 수의 배수면, 그 스위치의 상태를 바꾼다
 * 여자 : 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서
 * 		가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태 모두 바꿈
 * 
*/
public class Main_bj_1244_스위치켜고끄기 {
	static int[] sw; // 스위치 배열
	static int stnum; // 학생 수
	static int gender, chnum; // 성별과 받은수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()); //스위치의 갯수
		StringTokenizer st = new StringTokenizer(br.readLine());
		sw = new int[num];
		for (int i = 0; i < num; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		stnum = Integer.parseInt(br.readLine());
		for (int i = 0; i < stnum; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			chnum = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				for (int j = 0; j < num; j++) {
					if((j+1) % chnum == 0) {
						sw[j] = sw[j] == 0 ? 1 : 0;
					}
				}
			}else {
				sw[chnum-1] = sw[chnum-1] == 0 ? 1 : 0; //자기 위치의 수 바꿈
				for (int j = 1; j < num/2; j++) {
					if(chnum - 1 + j >= num || chnum-1-j < 0) break;
					if(sw[chnum-1 -j] == sw[chnum-1+j]) {
						sw[chnum-1-j] = sw[chnum-1-j] == 0 ? 1 : 0;
						sw[chnum-1+j] = sw[chnum-1+j] == 0 ? 1 : 0;
					}
					else {
						break;
					}
				}
			}
		}
		for (int i = 0; i < num; i++) {
			System.out.print(sw[i] + " ");
			if((i+1) % 20 == 0) {
				System.out.println();
			}
		}
	}
}
