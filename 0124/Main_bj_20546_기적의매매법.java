package Algo0124;

import java.util.*;
import java.io.*;

/*
 * 준현은 먼저 오는 순서대로 가격이 같거나 작으면 그 가격에 다산다.
 * 그리고 마지막날 가격으로 판다.
 * 성민은 3일 연속 가격이 떨어지면 다음날 가격으로 전량 매수한다.
 * 그리고 3일 연속 가격이 올라가면 다음날 가격으로 전량 매도한다.
*/
public class Main_bj_20546_기적의매매법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cash = sc.nextInt();
		int[] day = new int[14];
		int JH = 0;
		int JHCnt = 0;
		int JHCash = cash;
		int SM = 0;
		int SMCnt = 0;
		int SMCash = cash;
		for (int i = 0; i < 14; i++) {
			day[i] = sc.nextInt(); // 입력
		}

		for (int i = 0; i < 14; i++) {
			JHCnt = 0;
			if (JHCash == 0)
				break;
			JHCnt = JHCash / day[i];
			JH += day[13] * JHCnt;
			JHCash = JHCash % day[i];
		}
		JH = JH + JHCash;
//		System.out.println(JH);

		for(int i=0; i<=11; i++) {
			if(i==11) {
				SM += (SMCnt * day[13]) + SMCash;
				break;
			}
//			if(SMCash == 0) break;
			if(day[i] > day[i+1] && day[i+1] > day[i+2]) {
				SMCnt += SMCash / day[i+3];
//				SMTotalCnt += SMCnt;
				SMCash = SMCash % day[i+3];
			}
			if(day[i] < day[i+1] && day[i+1] < day[i+2]) {
				SM += day[i+3] * SMCnt;
				SMCnt = 0;
			}
			
		}
//		System.out.print(SM);
		if(JH > SM) {
			System.out.print("BNP");
		}else if(JH < SM){
			System.out.print("TIMING");
		}else {
			System.out.print("SAMESAME");
		}

	}

}
