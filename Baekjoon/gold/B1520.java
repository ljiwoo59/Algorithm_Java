import java.io.*;
import java.util.*;

// 백준 1520 내리막 길 Gold 4

public class B1520 {
	static int R, C;
	static int[][] map, dp;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		dp = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		result = dfs(0, 0, map[0][0]);
		
		System.out.println(result);
		br.close();
	}

	private static int dfs(int r, int c, int num) {
		if (r == R - 1 && c == C - 1) return 1;
		if (dp[r][c] != -1) return dp[r][c];
		dp[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nxr = r + d[i][0];
			int nxc = c + d[i][1];
			if (nxr >= 0 && nxr < R && nxc >= 0 && nxc < C && map[nxr][nxc] < num)
				dp[r][c] += dfs(nxr, nxc, map[nxr][nxc]);
		}
		return dp[r][c];
	}
	
}
