import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
	//	System.setIn(new FileInputStream("res/input_bj_1931.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		
		int[][] time = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			time[i][0] = sc.nextInt(); //시작시간
			time[i][1] = sc.nextInt(); //종료시간
		}
		
		Arrays.sort(time, new Comparator<int[] >() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0] - o2[0]; //만약 종료시간이 같을경우 시작시간이 빠른순서로
				}
				return o1[1] - o2[1]; //종료시간 순서로 정렬
			}
		});
		
		int cnt = 0;
		int prev_end_time = 0;
		
		for (int i = 0; i < N; i++) {
			if(prev_end_time<= time[i][0]) {
				prev_end_time = time[i][1];
				cnt++;
			}
		}
		sc.close();
		System.out.println(cnt);
	}

}
