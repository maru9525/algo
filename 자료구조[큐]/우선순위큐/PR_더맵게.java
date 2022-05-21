package Algo0521;

import java.util.*;
public class PR_더맵게 {
	//가장 낮은거 + 2번째 *2
	//K 이상이 될때까지 
	//모든 음식의 지수가 K 이상으로 만들기 위해 섞어야 하는 최소 횟수?
	class Solution {
	    public int solution(int[] scoville, int K) {
	        int answer = 0;
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        for(int i=0; i<scoville.length; i++){
	           pq.add(scoville[i]); 
	        }
	        
	        while(pq.peek() < K) {
	            if(pq.size() == 1 ){
	                return -1;
	            }
	            
	            pq.add(pq.poll() + pq.poll() * 2);
	            answer++;
	        }
	        return answer;
	    }
	}
}
