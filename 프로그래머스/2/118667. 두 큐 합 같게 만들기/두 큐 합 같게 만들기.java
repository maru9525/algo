import java.util.*;
//최소 횟수 bfs
//두개의 큐의 합이 동일할 경우

class Solution {
    static  Queue<Integer> q1 = new LinkedList<>();
    static  Queue<Integer> q2 = new LinkedList<>();
    static long target = 0;
    static long q1Sum = 0;
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum = 0;
        
        for(int i=0; i<queue1.length; i++) {
            q1.offer(queue1[i]);
            q1Sum += queue1[i];
            sum += queue1[i];
        }
        for(int i=0; i<queue2.length; i++) {
            q2.offer(queue2[i]);
            sum += queue2[i];
        }
        
        if(sum % 2 != 0) {
            return -1;
        } 
        target = sum / 2;
       
       
        
        
        while(true) {
            if(answer > (queue1.length + queue2.length) * 2) return -1; //길이 2배이면 더이상 순회 안됨
            if(q1Sum == target) break;
            else if(q1Sum > target) {
                q1Sum -= q1.peek();
                q2.offer(q1.poll());
            }else if(q1Sum < target) {
                q1Sum += q2.peek();
                q1.offer(q2.poll());
            }
            answer++;
        }
        
        return answer;
    }
   
}