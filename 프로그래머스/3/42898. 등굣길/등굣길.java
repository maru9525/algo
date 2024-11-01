class Solution {
    static int[][] dp;
    static int[] dm = {0,0,-1,1};
    static int[] dn = {-1,1,0,0};
    static boolean[][] visited;
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        int answer = 0;
        //연못 위치 체크
        for(int i=0; i<puddles.length; i++) {
            int x = puddles[i][1];
            int y = puddles[i][0];
            visited[x][y] = true;
        }
        dp[1][1] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(visited[i][j]) continue;
                if(!visited[i-1][j]) {
                    dp[i][j] += dp[i-1][j] % 1000000007;
                }
                if(!visited[i][j-1]) {
                    dp[i][j] += dp[i][j-1] % 1000000007;
                }
                
            }
        }
        
        answer = dp[n][m] % 1000000007;
        return answer;
    }
}