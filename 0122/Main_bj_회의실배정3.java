package Algo0122;
import java.util.*;
import java.io.*;
public class Main_bj_회의실배정3 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			arr[i][0] = start;
			arr[i][1] = end;
			arr[i][2] = people;
		}
		int[] dp = new int[N];
		int result = -123456789;
		dp[0] = arr[0][2];
		if(N >= 1) {
			result = dp[0];
		}
		if(N >= 2) {
			dp[1] = arr[1][2];
		}
		for(int i=2; i<N; i++) {
			dp[i] = arr[i][2] + result;
			result = Math.max(result, dp[i-1]);
		}
		result = Math.max(result, dp[N-1]);
		System.out.println(result);
		br.close();
		
	}

}
