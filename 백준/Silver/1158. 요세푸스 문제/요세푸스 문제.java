
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			q.offer(i); //q에 1부터 N 까지 삽입
		}
		sb.append("<");
		while(!q.isEmpty()) {
			if(q.size()==1) {
				sb.append(q.poll());
				break;
			}
			//m번째 숫자를 poll한다.
			for (int i = 0; i < M-1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
	

}
