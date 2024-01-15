import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0) return cities.length * 5;
        
        List<String> list = new LinkedList<>();
        for(int i=0; i<cities.length; i++) {
            String temp = cities[i].toUpperCase();
            if(list.remove(temp)) {
                answer += 1;
                list.add(temp);
            }else {
                answer += 5;
                if(list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(temp);
            }
        }
        
        return answer;
    }
}