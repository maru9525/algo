package Algo1204;

import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        // System.out.print(answer);
        int maxCnt = 0;
        int minCnt = 0;
        // System.out.print(Arrays.toString(lottos));
        for(int i=0; i<6; i++){
            
            if(lottos[i] == 0) {
                maxCnt++;
                continue;
            }
            for(int j=0; j<6; j++){
                if(lottos[i] == win_nums[j]){
                    maxCnt++;
                    minCnt++;
                }
            }
        }
        for(int i=1; i<=6; i++){
            if(maxCnt == i) answer[0] = (7-i);
            if(maxCnt == 0) answer[0] = 6;
            if(minCnt == i) answer[1] = (7-i);
            if(minCnt == 0) answer[1] = 6;
        }
        return answer;
    }
}