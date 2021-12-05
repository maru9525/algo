package Algo1205;

import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] snum = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] num = {"0","1","2","3","4","5","6","7","8","9"};
        for(int i =0; i<10; i++){
            s = s.replace(snum[i], num[i]);
            // System.out.print(s);
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}