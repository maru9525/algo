import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        //중복 제외하고 수열의 합 갯수
        //전부다 더한 값을 set에다가 넣으면 갯수가 나올거
        int start = 1;
        while(start <= elements.length) {
            for(int i=0; i<elements.length; i++) {
                int value = 0;
                for(int j=i; j<i + start; j++) {
                    value += elements[j % elements.length];
                }
                set.add(value);
            }  
            start++;
        }
        return set.size();
        
        
        
        
        // return answer;
    }
}