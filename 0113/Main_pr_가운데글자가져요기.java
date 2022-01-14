package Algo0113;

public class Main_pr_가운데글자가져요기 {
	public String solution(String s) {
        String answer = "";
        if(s.length()%2 == 0){
            answer = s.substring(s.length()/2-1, s.length()/2+1);
        }else if(s.length()%2 !=0){
            answer = s.substring(s.length()/2, s.length()/2+1);
        }
        return answer;
    }

}
