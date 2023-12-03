class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
       
        //인덱스 길이만큼 바꾸고 나서 skip 값과 비교해서 
        for(int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            for(int j=0; j<index; j++) {
                temp += 1;
                if(temp > 'z') {
                    temp -= 26;
                }
                if(skip.contains(String.valueOf(temp))) {
                    j--;
                }
            }
            answer += temp;
        }
        
        
        
        
        return answer;
    }
}