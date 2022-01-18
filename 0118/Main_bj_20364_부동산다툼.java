package Algo0118;
import java.io.BufferedReader;
import java.util.*;
import java.io.*;
public class Main_bj_20364_부동산다툼 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int K = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			int cur = Integer.parseInt(br.readLine());
			int t = cur;
			int temp = 0;
			
			while(true) {
				if(t==0) break;
				if(set.contains(t)) temp=t;
				t /= 2;
			}
			System.out.println(temp);
			if(temp == 0) {
				set.add(cur);
			}
		}
	}

}
