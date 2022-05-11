package Algo0511;

import java.util.*;
public class PR_없는숫자더하기 {
	// numbers에 없는 0~9까지의 숫자를 더한 수 return
	class Solution {
	    public int solution(int[] numbers) {
	        int[] cnt = new int[10];
	        int answer = 0;
	        for(int i=0; i<numbers.length; i++){
	            cnt[numbers[i]]++;
	        }
	        for(int c : cnt) System.out.print(c);
	        for(int i=0; i<10; i++){
	            if(cnt[i] != 1) {
	                answer += i;
	            }
	        }
	        
	        return answer;
	    }
	}
}
