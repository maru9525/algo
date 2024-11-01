import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        //2차원 배열 오름차순 정렬
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
       
        int temp = routes[0][1];
        
        for(int i=1; i<routes.length; i++) {
            //나가는 지점이 다음 시작 지점보다 작을경우 다음 끝점을 temp 값에 넣는다 
            //answer++
            if(temp < routes[i][0]) {
                temp = routes[i][1];
                answer++;
            }

        }
    
        return answer;
    }
}