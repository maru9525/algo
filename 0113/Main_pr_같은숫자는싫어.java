package Algo0113;

import java.util.*;

public class Main_pr_같은숫자는싫어 {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int preNum = 10;
        for(int n : arr){
            if(preNum != n){
                list.add(n);
            }
            preNum = n;
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}