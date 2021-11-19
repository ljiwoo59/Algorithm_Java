import java.io.*;
import java.util.*;

// 백준 16172 나는 친구가 적다 (Large) Gold 3

public class B16172 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		origin = origin.replaceAll("[0-9]", "");
		
		char[] text = origin.toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tlen = text.length, plen = pattern.length;
		
		int[] pi = new int[plen];
		for (int i = 1, j = 0; i < plen; i++) {
			while (pattern[i] != pattern[j] && j > 0)
				j = pi[j - 1];
			if (pattern[i] == pattern[j])
				pi[i] = ++j;
		}
		
		int res = 0;
		
		end: for (int i = 0, j = 0; i < tlen; i++) {
			while (text[i] != pattern[j] && j > 0)
				j = pi[j - 1];
			if (text[i] == pattern[j]) {
				if (j == plen - 1) {
					res = 1;
					break end;
				}
				else j++;
			}
		}
		
		System.out.println(res);
		
		/*
		start = start.replaceAll("[0-9]", "");
		if (start.contains(end)) System.out.println(1);
		else System.out.println(0);
		br.close();
		*/
	}

}
