package Algo0310;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1476_날짜계산 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int num = 1;
		//3개의 수 최소공배수를 구한다. 거기서 시작
		while(true) {
			//end
			if((num-E)%15==0 && (num-S)%28==0 && (num-M)%19==0) {
				break;
			} 
			//num%15 == E 로 할경우 값이 0으로 나오기 때문에
			//  다음과 같이 num-E 하고 나머지 계산을 한다.
			num++;
		}
		System.out.println(num);
	}

}
