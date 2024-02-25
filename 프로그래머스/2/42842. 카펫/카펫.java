class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int i=3; i<total; i++) {
            
            int c = total / i;
            int x = Math.max(c, i);
            int y = Math.min(c, i);
            if(x < y) continue;
            
            if((x-2)*(y-2) == yellow) {
                answer[0] = x;
                answer[1] = y;
                return answer;
            }
        }
        return answer;
    }
}