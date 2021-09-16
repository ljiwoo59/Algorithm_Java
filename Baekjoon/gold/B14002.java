package gold;

import java.io.*;
import java.util.*;

// 백준 14002 가장 긴 증가하는 부분 수열 4 Gold 4

public class B14002 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[2][N];
		int[] idx = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			dp[0][i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		int lastidx = 0;
		for (int i = 0; i < N; i++) {
			dp[1][i] = 1;
			
			for (int j = 0; j < i; j++) {
				if (dp[0][j] < dp[0][i] && dp[1][i] < dp[1][j] + 1) {
					dp[1][i] = dp[1][j] + 1;
					idx[i] = j;
				}
			}
			
			if (max < dp[1][i]) {
				max = dp[1][i];
				lastidx = i;
			}
		}
		
		int[] answer = new int[max];
		for (int i = max - 1; i >= 0; i--) {
			answer[i] = dp[0][lastidx];
			lastidx = idx[lastidx];
		}
		
		sb.append(max + "\n");
		for (int i : answer) {
			sb.append(i + " ");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

}
