package Algo0509;

public class PR_소수구하기 {
	static class Solution {
	    public int solution(int[] nums) {
	        int answer = 0;
	        int temp = 0;
	        boolean check = false;
	        for(int i=0; i<nums.length; i++){
	            for(int j=i+1; j<nums.length; j++){
	                for(int k=j+1; k<nums.length; k++){
	                    temp = nums[i] + nums[j] + nums[k];
	                    answer += prime(temp) ? 1 : 0;
	                }
	            }
	        }
	        
	        return answer;
	    }
	    static boolean prime(int num){
	        for(int i=2; i<= Math.sqrt(num); i++){
	            if(num % i ==0) {
	                return false;
	            }
	        }
	        return true;
	    }
	}
}
