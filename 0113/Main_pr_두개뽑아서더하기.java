package Algo0113;

import java.util.*;
class Main_pr_두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        // int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=0; j<numbers.length; j++){
                if(i==j) continue;
                int temp = numbers[i] + numbers[j];
                if(!list.contains(temp)){
                    list.add(temp);
                }
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
