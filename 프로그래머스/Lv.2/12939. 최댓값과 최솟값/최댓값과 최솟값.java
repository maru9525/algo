import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        // System.out.print();
        // String[] str = new String[s.split(" ")];
        int n = s.split(" ").length;
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(s.split(" ")[i]);
        }
        Arrays.sort(arr);

        answer += arr[0] + " " + arr[n-1] ;

        
        return answer;
    }
}