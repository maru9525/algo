import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        // System.out.print(stack.peek());
        // while(!stack.isEmpty()) {
        
        for(int i=1; i<s.length(); i++) {
            if(!stack.isEmpty()) {
                // System.out.println("peek : " + stack.peek());
                // System.out.println("i번째 수 : " + s.charAt(i));
                if(stack.peek() == s.charAt(i)) {
                    
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
                
            }else {
                stack.push(s.charAt(i));
            }
            
                          
        }
        // }
        
        if(!stack.isEmpty()) {
            answer = 0;
        }else {
            answer = 1;
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");

        return answer;
    }
}