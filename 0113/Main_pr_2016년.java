package Algo0113;

public class Main_pr_2016년 {
	 public String solution(int a, int b) {
	        String answer = "";
	        String[] eday = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
	        int[] day = {31, 29,31,30,31,30,31,31,30,31,30,31};
	        // System.out.print(eday[1]);
	        // System.out.print(day[1]);
	        int dsum = 0;
	        for(int i=0; i<a-1; i++){
	            dsum += day[i];
	        }
	        int sum = dsum + b -1;
	        // System.out.print(sum);
	        answer = eday[sum%7];
	        
	        return answer;
	    }

}
