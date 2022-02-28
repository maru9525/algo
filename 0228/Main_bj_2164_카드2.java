package Algo0228;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_bj_2164_카드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		//1~n까지의 수를 queue에 넣는다
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		while(true) {
			if(q.size() == 1) {
				break;
			}
			//가장 위에 카드를 버린다.
			q.poll();
			//그다음 거를 젤 밑으로 옮긴다.
			q.offer(q.poll());
		}
		//마지막으로 남는거 출력
		System.out.print(q.poll());
	}

}
