import java.io.*;
import java.util.*;
public class Main{
    static int N, M;
    static int cnt;
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, String> map =  new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            map.put(i, br.readLine()); // 맵에 비교할 문자열 입력
        }
        for (int i = 0; i < M; i++) {
            if(map.containsValue(br.readLine())) cnt++; //문자열 입력 후 같은 value가 있으면 cnt증가
        }
        System.out.print(cnt);
    }
}
