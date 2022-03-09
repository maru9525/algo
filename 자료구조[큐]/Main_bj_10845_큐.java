package Algo0309;
import java.io.*;
import java.util.*;
public class Main_bj_10845_큐 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<String> q = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		String check = "";
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) {
				String temp = st.nextToken();
				check = temp;
				q.offer(temp);
			}else if(str.equals("pop")) {
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.poll()).append("\n");
			}else if(str.equals("size")) {
				sb.append(q.size()).append("\n");
			}else if(str.equals("empty")) {
				if(q.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}else if(str.equals("front")) {
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.peek()).append("\n");
			}else if(str.equals("back")) {
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(check).append("\n");
			}
		}
		System.out.print(sb.toString());
	}

}
