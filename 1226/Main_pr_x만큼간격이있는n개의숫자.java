package Algo1226;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long nx = x;
        for(int i =1; i<=n; i++){
            answer[i-1] += nx*i;
        }
        return answer;
    }
}