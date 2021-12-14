package Algo1214;

import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftStart = 10;
        int rightStart = 12;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                leftStart = numbers[i];
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                rightStart = numbers[i];
            }else {
                int lLen = getLength(leftStart, numbers[i]);
                int rLen = getLength(rightStart, numbers[i]);
                
                if(lLen > rLen){
                    sb.append("R");
                    rightStart = numbers[i];
                }else if(lLen < rLen){
                    sb.append("L");
                    leftStart = numbers[i];
                }else {
                    if(hand.equals("right")){
                        sb.append("R");
                        rightStart = numbers[i];
                    }else {
                        sb.append("L");
                        leftStart = numbers[i];
                    }
                }
            }
        }
                
        return sb.toString();
    }
    public static int getLength(int i, int number){
        i = (i ==0) ? 11 : i;
        number = (number == 0)? 11 : number;
        
        int x = (i-1)/3;
        int y = (i-1) % 3;
        int numberX = number / 3;
        int numberY = 1;
        
        return Math.abs(x-numberX) + Math.abs(y-numberY);
    }
}