package gold;

import java.io.*;
import java.util.*;

// 백준 9084 동전 Gold 5

public class B9084 {
	static int T, N, dest;
	static int[] money;
	static int[] dp;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			money = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			dest = Integer.parseInt(br.readLine());
			dp = new int[dest + 1];
			
			dp[0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = money[i]; j <= dest; j++) {
					dp[j] += dp[j - money[i]];
				}
			}
			
			sb.append(dp[dest] + "\n");
		}
		System.out.print(sb);
		br.close();
	}
}
