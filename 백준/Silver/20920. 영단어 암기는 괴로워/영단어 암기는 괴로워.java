import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            if(temp.length() < m) continue;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        // map에 넣은 단어 리스트로 저장
        List<String> list = new ArrayList<>(map.keySet());
        //Collection sort로 다중 정렬
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                //자주 등장하는 단어 순서
                if(Integer.compare(map.get(o1), map.get(o2)) != 0 ) {
                    return Integer.compare(map.get(o2), map.get(o1));
                }
                //등장 횟수 같으면 길이가 긴 단어 먼저
                if(o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                //등장 횟수와 길이가 같으면 사전 순으로 정렬
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
}