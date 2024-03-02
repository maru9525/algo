import java.util.*;
//장르,  노래별 재생 횟수
//장르, 재생횟수, 고유번호가 낮은순서
// 고유번호를 순서대로 리턴
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> count = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            if(!total.containsKey(genres[i])) {
                HashMap<Integer, Integer> temp = new HashMap<>();
                temp.put(i, plays[i]);
                total.put(genres[i], plays[i]);
                count.put(genres[i], temp);
            }else {
                count.get(genres[i]).put(i, plays[i]);
                total.put(genres[i], total.get(genres[i]) + plays[i]);
            }    
        }
        
        List<String> keySet = new ArrayList(total.keySet());
        Collections.sort(keySet, (s1, s2) -> total.get(s2) - (total.get(s1)));
        
        for(String key: keySet) {
            HashMap<Integer, Integer> map = count.get(key);
            List<Integer> genre_key = new ArrayList(map.keySet());
            
            Collections.sort(genre_key, (s1, s2) -> map.get(s2) - (map.get(s1)));
            answer.add(genre_key.get(0));
            if(genre_key.size() > 1) {
                answer.add(genre_key.get(1));
            }
            
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}