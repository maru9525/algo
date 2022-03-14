package Algo0311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_bj_10866_덱 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int num = 0;
			switch (str) {
			case "push_front":
				num = Integer.parseInt(st.nextToken());
				dq.addFirst(num);
				break;
			case "push_back":
				num = Integer.parseInt(st.nextToken());
				dq.addLast(num);
				break;
			case "pop_front":
				if (!dq.isEmpty())
					sb.append(dq.pollFirst()).append("\n");
				else sb.append(-1).append("\n");
				break;
			case "pop_back":
				if(!dq.isEmpty())
					sb.append(dq.pollLast()).append("\n");
				else sb.append(-1).append("\n");
				break;
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			case "empty":
				if(!dq.isEmpty())
					sb.append(0).append("\n");
				else 
					sb.append(1).append("\n");
				break;
			case "front":
				if(!dq.isEmpty())
					sb.append(dq.peekFirst()).append("\n");
				else 
					sb.append(-1).append("\n");
				break;
			case "back":
				if(!dq.isEmpty())
					sb.append(dq.peekLast()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
