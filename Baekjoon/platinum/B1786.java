package platinum;

import java.io.*;
import java.util.*;

// 백준 1786 찾기 Platinum 5

public class B1786 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tlen = text.length, plen = pattern.length;
		
		int[] pi = new int[plen];
		for (int i = 1, j = 0; i < plen; i++) {
			while (pattern[i] != pattern[j] && j > 0)
				j = pi[j - 1];
			if (pattern[i] == pattern[j])
				pi[i] = ++j;
		}
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0, j = 0; i < tlen; i++) {
			while (text[i] != pattern[j] && j > 0)
				j = pi[j - 1];
			if (text[i] == pattern[j]) {
				if (j == plen - 1) {
					cnt++;
					list.add((i + 1) - plen + 1);
					j = pi[j];
				}
				else j++;
			}
		}
		
		sb.append(cnt + "\n");
		for (int i : list) {
			sb.append(i + " ");
		}
		sb.setLength(sb.length() - 1);
		
		System.out.print(sb);
		br.close();
	}

}
