package gold;

import java.io.*;
import java.util.*;

// 백준 17070 파이프 옮기기 1 Gold 5

public class B17070 {
	static int N, result;
	static int map[][];
	static int dp[][][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[3][N + 1][N + 1];
		dp[0][1][2] = 1;
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (map[r][c] == 1) continue;
				dp[0][r][c] += dp[0][r][c - 1] + dp[2][r][c - 1]; // 가로
				dp[1][r][c] += dp[1][r - 1][c] + dp[2][r - 1][c]; // 세로
				if (map[r - 1][c] != 1 && map[r][c - 1] != 1)
					dp[2][r][c] += dp[0][r - 1][c - 1] + dp[1][r - 1][c - 1] + dp[2][r - 1][c - 1]; // 대각선
			}
		}
		
		result = dp[0][N][N] + dp[1][N][N] + dp[2][N][N];
		System.out.println(result);
		br.close();
	}

}
