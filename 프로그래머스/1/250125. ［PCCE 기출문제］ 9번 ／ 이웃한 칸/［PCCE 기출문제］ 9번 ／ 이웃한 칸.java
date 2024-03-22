class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        // int a = board.length;
        // System.out.print("a :" + a);
        // int b = board[0].length;
        // System.out.print("b :" + b);
        // String str = board[h][w];
        // System.out.print(str);
        for(int d=0; d<4; d++) {
            int px = h+dx[d];
            int py = w+dy[d];
            if(px >= 0 && px < board.length && py >= 0 && py < board[0].length) {
                
                String temp = board[h+dx[d]][w+dy[d]];
                if(temp.equals(board[h][w])) {
                    answer++;
                }
                // System.out.print("temp :  " + temp);
            }


        }
        
        
        return answer;
    }
}