package Algo0113;

class Solution {
    public String solution(String s) {
        String answer = "";
        int sLen = s.length();
        String[] word = s.split("");
        int blank = 0;
        for(int i=0; i<sLen; i++){
            if(word[i].equals(" ")) {
                blank =0;
            }
            // System.out.print(word[i]);
            else if(blank %2 == 0){
                word[i] = word[i].toUpperCase();
                blank++;
            }else if(blank%2 != 0){
                word[i] = word[i].toLowerCase();
                blank++;
            }
            // System.out.print(word[i]);
            answer += word[i];
        }
        
        return answer;
    }
}