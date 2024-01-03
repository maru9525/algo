import java.util.*;
class Solution {
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return max;
    }
    
    static void dfs(int cnt, int k, int[][] arr) {
        for(int i=0; i<arr.length; i++) {
            if(!visited[i] && arr[i][0] <= k) {
                visited[i] = true;
                dfs(cnt + 1, k-arr[i][1], arr);
                visited[i] = false;
            }
        }
       max = Math.max(max, cnt);
    }
}