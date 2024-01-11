import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
       
        for(int i=1; i<arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        
        
        return answer;
    }
    static int gcd(int a, int b) {
        int temp = 0;
        while(b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    static int lcm(int a, int b) {
        return (a * b) / gcd(a,b);
    }
}