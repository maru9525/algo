import java.util.*;
//ICN에서 출발 
//티켓[0] 이랑 [1]이 동일하여야한다.
//알파벳 순이 빠른순서로 
class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static boolean useTickets[];
    
    
    public String[] solution(String[][] tickets) {
        useTickets = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN" , tickets);
        
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    static void dfs(int depth, String now, String path, String[][] tickets) {
        if(depth == tickets.length) {
            list.add(path);
            // System.out.println("-------");
            // System.out.print(path);
            return;
        }
        
        for(int i=0; i < useTickets.length; i++) {
            if(!useTickets[i] && now.equals(tickets[i][0])) {
                useTickets[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                useTickets[i] = false;
                    
            }
        }
        
    }
    
}