class Solution {
    static int n,m;
    static char[][] map;
    public int[] solution(String[] park, String[] routes) {
        
        n = park.length;
        m = park[0].length();
        map = new char[n][m];
        String[] temp = new String[2];
        int sx = 0;
        int sy = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = park[i].charAt(j);
                if(map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }
        

        for(int d=0; d<routes.length; d++) {
            String dir= routes[d].split(" ")[0];
            int dis = Integer.parseInt(routes[d].split(" ")[1]);
            int px = sx;
            int py = sy;
            for(int i=0; i<dis; i++) {
                if(dir.equals("E")) {
                    py++;
                }else if(dir.equals("W")) {
                    py--;
                }else if(dir.equals("S")) {
                    px++;
                }else if(dir.equals("N")) {
                    px--;
                }
                
                if(px >= 0 && px < n && py >= 0 && py < m && map[px][py] != 'X') {
                    // 범위내 & 장애물 x
                    if(i == dis-1){
                        sx = px;
                        sy = py;
                    }

                }else {
                    break;
                }
            }
           

        }
        int[] answer = {sx, sy};
        
        return answer;
    }
   
}