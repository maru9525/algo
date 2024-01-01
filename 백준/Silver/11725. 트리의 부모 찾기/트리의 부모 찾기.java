

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] tree;
    static boolean[] visited;
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        tree = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for (int i = 2; i < tree.length; i++) {
            System.out.println(tree[i]);
        }
    }
    static void dfs(int index) {
        visited[index] = true;
        for(int i: list[index]) {
            if(!visited[i]) {
                tree[i] = index;
                dfs(i);
            }
        }
    }
}

//1-6-3-5
//4-1
//2-4-7
