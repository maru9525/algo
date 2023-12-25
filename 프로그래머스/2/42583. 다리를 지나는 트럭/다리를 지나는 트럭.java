import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        int len = truck_weights.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<len; i++) {
            int truck = truck_weights[i];
            
            while(true) {
                if(q.isEmpty()) {
                    q.offer(truck);
                    sum += truck;
                    answer++;
                    break;
                }else if(q.size() == bridge_length) {
                    sum -= q.poll();
                }else {
                    if(sum + truck <= weight) {
                        q.offer(truck);
                        sum += truck;
                        answer++;
                        break;
                    } else {
                        q.offer(0);
                        answer++;
                    }
                }
            }
        }
        return bridge_length + answer;
    }
}