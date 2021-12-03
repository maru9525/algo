package Algo1203;

import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        // System.out.print(numbers.length);
        String[] s = new String[numbers.length];
        for(int i=0; i<s.length; i++){
            s[i] = Integer.toString(numbers[i]);
            // System.out.print(s[i]);
        }
        Arrays.sort(s, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return ((o2+o1).compareTo(o1+o2));
            }
        });
        if(s[0].equals("0")) return "0";
        for(String str : s) answer += str;

        return answer;
    }
}