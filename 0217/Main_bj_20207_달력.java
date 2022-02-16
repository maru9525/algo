package Algo0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 일정이 있는 곳만 코팅지를 붙인다.
 * 연속된 일자에 1개 이상의 일정이 있으면 이는 연속됨
 * 연속된 모든 일정은 하나의 직사각형에 포함됨
 * 연속된 일정을 모두 감싸는 가장 작은 직사각형 코팅지.
*/
public class Main_bj_20207_달력 {
	static int N;
	static int[][] cal;

	static class Pair {
		int start, end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		PriorityQueue<Pair> pq = new PriorityQueue<>((e1, e2) -> {
			if (e1.start == e2.start)
				return e2.end - e1.end;
			return e1.start - e2.start;
		});
		int maxday = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			pq.add(new Pair(u,v));
			maxday = Math.max(maxday, v); //끝날 구함
		}
		cal = new int[N][maxday + 2];
		//달력 만들기
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			for (int i = 0; i < N; i++) {
				//이미 배치됐다면
				if(cal[i][p.start] == 1) continue;
				//아니면 일정 배치
				for (int j = p.start; j <= p.end; j++) {
					cal[i][j] = 1;
				}
				break;
			}
		}
		int wstart = 365;
		int wend = 0;
		int height = 0;
		int sum = 0;
		
		//블럭의 좌우 끝과 높이를 구함
		for (int i = 1; i < cal[0].length; i++) {
			boolean stop = true;
			for (int j = 0; j < N; j++) {
				if(cal[j][i] == 1) {
					wend = Math.max(wend, i); //마지막 수업 끝
					wstart = Math.min(wstart, i); // 첫 수업 시작
					height = Math.max(height, j+1); //겹치는 수업
					stop = false;
				}
			}
			//위 for문에서 세로롤 탐색했을 때 stop이 false 가 안됐다는 것은 해당 시간대에 일정이 없다.
			//즉, 블럭이 형성된다고 함.
			//블럭 만들어지면 블럭 계산하고 값들을 초기화 함.
			if(stop) {
				sum += ((wend - wstart + 1) * height);
				wstart = 365;
				wend = 0;
				height = 0;
			}
		}
		System.out.println(sum);
		

	}

}
