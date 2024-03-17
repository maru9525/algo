

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 0;
        int val = 1;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
                val *= 2;
            }else if(str.charAt(i) == '['){
                stack.push('[');
                val *= 3;
            }else if(str.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }else if(str.charAt(i-1) == '(') {
                    result += val;
                }
                stack.pop();
                val /= 2;

            }else if(str.charAt(i) == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }else if(str.charAt(i-1) == '[') {
                    result += val;
                }
                stack.pop();
                val /= 3;
            }

        }
        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(result);


    }
}
