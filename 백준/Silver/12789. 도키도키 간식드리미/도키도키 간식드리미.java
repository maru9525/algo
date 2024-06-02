

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int n;


    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String answer = "";
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            q.offer(sc.nextInt());
        }
        int cnt = 1;

        while(!q.isEmpty()) {
            if(q.peek() == cnt) {
                q.poll();
                cnt++;
            }else if(!stack.isEmpty() && stack.peek() == cnt) {
                stack.pop();
                cnt++;
            }else {
                stack.push(q.poll());
            }
        }
        
        while (!stack.isEmpty()) {
            if(stack.peek() == cnt) {
                stack.pop();
                cnt++;
            }else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");


    }



}
