

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Pair implements Comparable<Pair>{
        int w;
        int cost;
        public Pair(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }
    //노드에 연결되어 있는 노드에 대한 정보 리스트
    static ArrayList<Pair>[] graph;
    //방문 체크
    static boolean[] visited;
    //최단 거리 테이블
    static int[] dist;
    static int v, e, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        graph = new ArrayList[v + 1];
        dist = new int[v + 1];
        visited = new boolean[v + 1];

        //그래프 초기화, 최단거리 테이블 맥스값 지정
        for(int i=1; i<=v; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        //그래프에 입력값 셋팅
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[x].add(new Pair(y, cost));
        }

        //다익스트라 시작정점 K
        dijkstra(k);

        for (int i = 1; i <= v; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }

    }
    static void dijkstra(int start) {
        //우선순위 큐 가중치 기준 오름차순
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(start, 0));
        dist[start] = 0;

        //큐에서 cost가 가장 적은 노드 꺼내 방문 처리
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int pcost = p.cost;
            int pw = p.w;
            if(!visited[pw]) {
                visited[pw] = true;
            }
            //방문하지 않았고, 현재 노드 + 다른 노드 = 현재 dist 값보다 작으면 해당 값으로 변경

            for(Pair next : graph[pw]) {
                if(!visited[next.w] && dist[next.w] > pcost + next.cost) {
                    dist[next.w] = pcost + next.cost;
                    pq.offer(new Pair(next.w, dist[next.w]));
                }
            }



        }
        
    }
}
