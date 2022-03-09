package Algo0308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_bj_1406_에디터_연결리스트_시간초과 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String comm = br.readLine();
		LinkedList<Character> list = new LinkedList<>();
		for (int i = 0; i < comm.length(); i++) {
			list.add(comm.charAt(i)); //첫 문장 list에 삽입
		}
		int M = Integer.parseInt(br.readLine());
		int cursor = list.size();
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			char c = str.charAt(0);
			if(c =='P') { //P이면
				char t = str.charAt(2);
				list.add(cursor,t ); //다음 문자를 list에 넣는다.
				cursor++;
			}else if(c =='L') {
				if(cursor != 0) {
					cursor -= 1;
				}
			}else if(c =='D') {
				if(cursor != list.size()) {
					cursor += 1;
				}
			}else if(c =='B') {
				if(cursor != 0) {
					list.remove(cursor-1);
					cursor--;
				}
			}
		}
		for(Character c: list) {
			System.out.print(c);
		}
		
		
	}

}
