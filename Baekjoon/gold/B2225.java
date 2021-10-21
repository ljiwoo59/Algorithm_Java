package gold;

import java.io.*;
import java.util.*;

// 백준 2225 합분해 Gold 5

public class B2225 {
	static int N, K, mod = 1000000000;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K + 1][N + 1];
		for (int i = 0; i <= K; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
			}
		}
		System.out.println(dp[K][N]);
		br.close();
	}

}
