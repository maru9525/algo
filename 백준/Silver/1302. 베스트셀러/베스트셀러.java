

import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
    
            map.put(str, map.getOrDefault(str, 0) + 1);
            max = Math.max(max, map.get(str));
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String temp :
                list) {
            if (map.get(temp) == max) {
                System.out.println(temp);
                return;
            }
        }

    }

}
