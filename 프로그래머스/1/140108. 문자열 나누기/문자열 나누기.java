class Solution {
    public int solution(String s) {
        int answer = 1;
        char ft = s.charAt(0);
        int diff = 1;

        
        for(int i=1; i<s.length(); i++) {
            if(diff == 0){
                answer++;
                ft = s.charAt(i);
            }
            
            if(ft == s.charAt(i)) {
                diff++;
            }else {
                diff--;
            }
        }
        return answer;
    }
}