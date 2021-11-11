package gold;

import java.io.*;
import java.util.*;

// 백준 9252 LCS 2 Gold 5

public class B9252 {
	static char[] first, second;
	static int[][] dp;
	static char[] s = new char[1000];
	static LinkedList<int[]> queue = new LinkedList<>();
	static int[][] d = {{-1, 0}, {0, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		first = br.readLine().toCharArray();
		second = br.readLine().toCharArray();
		
		dp = new int[first.length + 1][second.length + 1];
		
		for (int i = 1; i <= first.length; i++) {
			for (int j = 1; j <= second.length; j++) {
				if (first[i-1] == second[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					s[dp[i][j] - 1] = first[i-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int res = dp[first.length][second.length];
		sb.append(res + "\n");
		
		if (res != 0) {
			int i = first.length;
			int j = second.length;
			while (dp[i][j] != 0) {
				if (dp[i][j] == dp[i-1][j]) i--;
				else if (dp[i][j] == dp[i][j-1]) j--;
				else {
					s[dp[i][j]-1] = first[i-1];
					i--;
					j--;
				}
			}
			sb.append(String.valueOf(s) + "\n");
		}

		System.out.print(sb);
		br.close();
	}

}
