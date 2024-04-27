import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) +1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int sum = 0; 
        for(int i=0; i<list.size(); i++) {
            int temp = list.get(i);
            if(temp + sum < k) {
                sum += temp;
                answer++;
            }else {
                answer++;
                break;
            }
        }
        
        return answer;
    }
}