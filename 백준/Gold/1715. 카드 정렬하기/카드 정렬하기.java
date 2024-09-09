import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int answer;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }


        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            answer += a + b;
            pq.add(a + b);
        }
        System.out.println(answer);
    }
}