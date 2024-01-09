import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[] result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        //맵 key value
        //갯수 카운트
        //2번째 b 입력 값과 동일한 키의 value 출력
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String num = st.nextToken();
            map.put(num, map.getOrDefault(num, 0) + 1);

        }
        List<String> list = new ArrayList<>(map.keySet());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(br.readLine());
        result = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            String num = st.nextToken();
            sb.append(map.getOrDefault(num, 0)).append(" ");

        }
        System.out.println(sb.toString());
    }

}
