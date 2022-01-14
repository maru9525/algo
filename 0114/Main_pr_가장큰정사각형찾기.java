package Algo0114;

import java.util.*;
class Solution2
{
    static class Point{
        int r;
        int c;
        int cnt;
        Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static boolean visited[][];
    static int[] dx = {0,1,1}; //밑, 오른쪽대각선, 오른쪽
    static int[] dy = {1,0,1};
    static int result = 0;
    public int solution(int [][]board)
    {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                visited = new boolean[board.length][board[0].length];
                if(board[i][j] == 1){
                    result = Math.max(result, 1);
                    bfs(i,j, board);
                }
            }
        }

        return result * result;
    }
    public static void bfs(int i, int j, int[][] board){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j, 1));
        visited[i][j] = true;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int d=0; d<3; d++){
                int nx = p.r + dx[d];
                int ny = p.c + dy[d];
                if(nx >=0 && nx<board.length && ny>=0 && ny<board[0].length){
                    if(!visited[nx][ny]){
                        if(board[nx][ny] == 0){
                            result = Math.max(result, p.cnt);
                            return;
                        }
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny, p.cnt + 1));
                    }
                }else{
                    result = Math.max(result , p.cnt);
                    return;
                }
            }
            if(q.isEmpty()){
                result = Math.max(result, p.cnt -1);
            }
        }
    }
}