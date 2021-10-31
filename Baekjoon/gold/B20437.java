package gold;

import java.io.*;
import java.util.*;

// 백준 20437 문자열 게임 2 Gold 5

public class B20437 {
	static int T, N;
	static char[] str;
	static ArrayList<Integer>[] indexList; // 알파벳 당 인덱스 위치
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			str = br.readLine().toCharArray();
			N = Integer.parseInt(br.readLine());
			indexList = new ArrayList[26];
			for (int i = 0; i < 26; i++) {
				indexList[i] = new ArrayList<>();
			}
			
			// 알파벳 인덱스 위치 채우기
			for (int i = 0; i < str.length; i++) {
				indexList[str[i] - 'a'].add(i);
			}
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			// N 개보다 많거나 같은 알파벳 찾고 인덱스 계산
			for (int i = 0; i < 26; i++) {
				int size = indexList[i].size();
				if (size >= N) {
					for (int j = 0; j <= size - N; j++) {
						min = Math.min(min, (indexList[i].get(j + N - 1)) - indexList[i].get(j));
						max = Math.max(max, (indexList[i].get(j + N - 1)) - indexList[i].get(j));
					}
				}
			}
			
			if (max == Integer.MIN_VALUE) sb.append(-1 + "\n");
			else sb.append((min + 1) + " " + (max + 1) + "\n");
		}

		System.out.print(sb);
		br.close();
	}

}
