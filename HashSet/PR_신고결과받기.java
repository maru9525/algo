package Algo0509;

import java.util.*;

public class PR_신고결과받기 {
	// 각 유저는 한번에 한명의 유저를 신고할 수 있다.
	// 신고 횟수 제한 X, 한 유저를 여러번 신고할 수 있지만, 동일한 유저에 대한 신고횟수는 1회로 처리됨
	// K번 이상 신고된 유저는 게시판 이용 정지.
	// 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
	// 처리 결과 메일을 받은 수 RETURN
	// 풀이방법
	// HashSet으로 중복 제거한다.
	// 누가 신고했는지에 대한 id를 map에 저장
	// map 사이즈가 k 이상이면 해당 map에 있는 id에 대해 ++
	class Solution {
		public int[] solution(String[] id_list, String[] report, int k) {
			int[] answer = new int[id_list.length]; // 아이디 리스트 만큼의 결과 값이 나온다.
//	        int rlen = report.length;
			Map<String, HashSet<String>> map = new HashMap<>();
			Map<String, Integer> rmap = new HashMap<>();

			for (int i = 0; i < id_list.length; i++) {
				String str = id_list[i];
				map.put(str, new HashSet<>());
				rmap.put(str, i);
			}

			for (int i = 0; i < report.length; i++) {
				String id = report[i].split(" ")[0];
				String re = report[i].split(" ")[1];
				System.out.print(map.get(re));
				map.get(re).add(id);
			}

			for (int i = 0; i < id_list.length; i++) {
				HashSet<String> mail = map.get(id_list[i]);
				if (mail.size() >= k) {
					for (String m : mail) {
						answer[rmap.get(m)]++;
					}
				}

			}
			return answer;
		}
	}
}
