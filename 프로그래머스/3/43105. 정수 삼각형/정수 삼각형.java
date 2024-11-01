class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int h = triangle.length; //삼각형의 높이
        int[][] dp = new int[h][h]; //합 기록할 dp 배열
        
        //왼쪽 단계는 미리 저장
        dp[0][0] = triangle[0][0];
        for(int i=1; i<h; i++) {
            dp[i][0] = (dp[i-1][0] + triangle[i][0]);
        }
        //2번째 줄 부터(i=1) 내려가면서 최대값 구하기
        for(int i=1; i<h; i++) {
            for(int j=1; j<triangle[i].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j] );
            }
        }
        //삼각형 바닥에서 가장 큰 값 구하기
         for(int i=0; i<h; i++) {
             answer = Math.max(answer, dp[h-1][i]);
         }   
            
        return answer;
    }
}