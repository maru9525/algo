package Algo0509;

public class PR_신규아이디추천 {
	class Solution {
		public String solution(String new_id) {
			String answer = "";
			// 대문자 -> 소문자
			new_id = new_id.toLowerCase();
			// 2단계
			String temp = "";
			for (int i = 0; i < new_id.length(); i++) {
				char c = new_id.charAt(i);
				if (c >= 'a' && c <= 'z') {
					temp += String.valueOf(c);
				} else if (c >= '0' && c <= '9') {
					temp += String.valueOf(c);
				} else if (c == '-' || c == '_' || c == '.') {
					temp += String.valueOf(c);
				}
			}
			// System.out.println(temp);
			// 3단계
			String step3 = temp.toString().replace("..", ".");
			while (step3.contains("..")) {
				step3 = step3.replace("..", ".");
			}
			// System.out.println(step3);
			// 4단계
			String step4 = step3;
			if (step4.length() > 0) { // 젤 앞 . 삭제
				if (step4.charAt(0) == '.') {
					step4 = step4.substring(1, step4.length()); // 1부터 ~ 길이-1까지
				}
			}
			if (step4.length() > 0) { // 젤 뒤 . 삭제
				if (step4.charAt(step4.length() - 1) == '.') {
					step4 = step4.substring(0, step4.length() - 1);
				}
			}
			// 5단계
			String step5 = step4;
			if (step5.equals("")) {
				step5 = "a";
			}

			// 6단계
			String step6 = step5;
			if (step6.length() >= 16) {
				step6 = step6.substring(0, 15);
				if (step6.charAt(step6.length() - 1) == '.') {
					step6 = step6.substring(0, step6.length() - 1);
				}
			}
			// System.out.print(step6);
			// 7단계
			StringBuilder step7 = new StringBuilder(step6);
			if (step7.length() <= 2) {
				char l = step7.charAt(step7.length() - 1);
				while (step7.length() < 3) {
					step7.append(l);
				}
			}
			answer = String.valueOf(step7);
			return answer;
		}
	}
}
