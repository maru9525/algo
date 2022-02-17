package Algo0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_bj_19583_싸이버개강총회 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String start = st.nextToken();
		String end = st.nextToken();
		String quit = st.nextToken();
		
		Set<String> before = new HashSet<>();
		Set<String> after = new HashSet<>();
		Set<String> nameSet = new HashSet<>();
		String str = null;
		
		while((str = br.readLine()) != null) {
			String[] arr = str.split(" ");
			String time = arr[0];
			String name = arr[1];
			nameSet.add(name);
			if(start.compareTo(time) >= 0) {
				before.add(name);
			}else if(end.compareTo(time) <= 0 && quit.compareTo(time) >=0) {
				after.add(name);
			}
		}
		int result = 0;
		for(String name: nameSet) {
			if(before.contains(name) && after.contains(name)) {
				result++;
			}
		}
		System.out.println(result);
	}

}
