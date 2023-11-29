import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int len = photo.length;
        
        int[] answer = new int[len];
        
        //key value
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        // System.out.print(photo.length);
        //name 값이랑 photo[i].length 값이랑 돌려서 같으면 result에 yearning 값 넣고 아니면 패스
        for(int i=0; i<len; i++) {
            int result = 0;
            for(int j=0; j<photo[i].length; j++) {
                if(map.containsKey(photo[i][j])) {
                    result += map.get(photo[i][j]);
                }
            }
            answer[i] = result;
        }
        return answer;
    }
}