import java.io.*;
import java.util.*;

public class Main {
    static class Frog {
        int pos;
        int cnt;
        public Frog(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
    static int n;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        //징검다리 배열 입력
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //시작, 도착 지점
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        //bfs(시작, 도착)
        int cnt = bfs(start, end);
        System.out.println(cnt);
    }

    //bfs
    public static int bfs(int start, int end) {

        //방문처리 배열
        boolean[] visited = new boolean[n+1];
        //시작 지점 방문처리
        visited[start] = true;
        //queue 에 개구리의 상태 저장
        Queue<Frog> q = new LinkedList<>();
        q.offer(new Frog(start, 0));

        //q.isEmpty
        while(!q.isEmpty()) {
            Frog f = q.poll();
            //위치가 도착지점이라면 리턴
            if(f.pos == end) {
                return f.cnt;
            }
            //현재 위치에서 주어지는 정수의 배수만큼 갈 수 있음
            int jump = arr[f.pos];

            //뒤로 가는경우
            for (int i = f.pos; i >= 1; i-=jump) {
                //방문한 곳이라면 continue
                if(visited[i]) continue;
                //방문처리 후 해당 위치, cnt + 1 q에 삽입
                visited[i] = true;
                q.offer(new Frog(i, f.cnt + 1));
            }

            //앞으로 가는경우
            for (int i = f.pos; i <= n; i+= jump) {
                //방문한 곳 continue
                if(visited[i]) continue;
                //방문처리 후 해당 위치, cnt + 1 q에 삽입
                visited[i] = true;
                q.offer(new Frog(i, f.cnt + 1));
            }
        }
        return -1;
    }


}