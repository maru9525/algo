//n만큼 arr를 만들어서 몇번째로 가는지 확인(몇번째 탈락체크)
//잘못됐으면, 그 위치 /n 해서 나오는 나머지값, 0일경우에는 n으로 나타내고
//중복체크

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        boolean success = false;
        
        // int[] num = new int[n+1];
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<words.length; i++) {
            if(map.getOrDefault(words[i], 0) == 1) {
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                success = true;
                break;
            }
            
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            // 이전 끝단어와 현재 첫단어가 다른경우 - 끝말잇기가 아닌경우
            if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                success = true;
                break;
            }
           
        }
        
        if(!success) 
            return new int[] {0,0};
        
       
        return answer;
    }
}