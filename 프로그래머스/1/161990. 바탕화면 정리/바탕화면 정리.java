import java.util.*;

class Solution {
    static int mini1 = Integer.MAX_VALUE;
    static int minj1 = Integer.MAX_VALUE;
    static int maxi2 = Integer.MIN_VALUE;
    static int maxj2 = Integer.MIN_VALUE;
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    mini1 = Math.min(mini1, i);
                    minj1 = Math.min(minj1, j);
                    maxi2 = Math.max(maxi2, i);
                    maxj2 = Math.max(maxj2, j);
                }
            }
        }
        answer[0] = mini1;
         answer[1] = minj1;
         answer[2] = maxi2 + 1;
         answer[3] = maxj2 + 1;

        System.out.println(mini1 + ", " + minj1 + ", " + maxi2 + ", " + maxj2);
        
        return answer;
    }
}