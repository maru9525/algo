package Algo0125;

import java.util.*;
import java.io.*;

public class Main_bj_10808_알파벳갯수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int[] cnt = new int[26];

		for (int i = 0; i < word.length(); i++) {
			cnt[word.charAt(i)-'a']++;
		}
		for(int i=0; i<26; i++) {
			System.out.print(cnt[i] + " ");
		}

	}

}
