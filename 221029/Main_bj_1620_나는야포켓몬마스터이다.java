import java.io.*;
import java.util.*;
public class Main{
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<Integer, String> map = HashMap<>();
        Map<String, Integer> smap = HashMap<>();
        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            map.put(i, temp); // map에 입력
            smap.put(temp, i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            //입력한 값이 숫자면 value 리턴, 문자면 key 리턴
            String temp = br.readLine();
            if(checkValue(temp)){ // 숫자이면
                sb.append(map.get(Integer.valueOf(temp)) + "\n");
            }
            else {
                sb.append(smap.get(temp) + "\n");
            }
        }
        System.out.print(sb);

    }
    public static boolean checkValue(String a) {
        if(!Character.isDigit(a.charAt(0))){
            return false;
        }
        return true;


    }

}