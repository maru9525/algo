import java.util.*;

class Solution {
    
    static int[] map;
    static int check;
    static int answer;
    
    public int solution(int n) {
        answer = 0;
        check = n;
        map = new int[n];
        solve(0);
        
        return answer;
    }
    static void solve(int cnt) {
        if(cnt == check) {
            answer++;
            return;
        }
        
        for(int i=0; i<check; i++) {
            map[cnt] = i;
            if(pos(cnt)) {
                solve(cnt + 1);
            }
        }
    }
    
    public static boolean pos(int col) {
        for(int i=0; i<col; i++) {
            if(map[col] == map[i]) {
                return false;
            }
            
            if(Math.abs(col - i) == Math.abs(map[col]- map[i])) {
                return false;
            }
        }
        return true;
    }
}