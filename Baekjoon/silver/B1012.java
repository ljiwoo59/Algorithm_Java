import java.io.*;
import java.util.*;

// 백준 1012 유기농 배추 Silver 2

public class B1012 {
	static int M, N, K;
	static int[][] map;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			result = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 1) {
						result++;
						dfs(r, c);
					}
				}
			}
			sb.append(result + "\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static void dfs(int row, int col) {
		if (map[row][col] == 0)
			return;
		map[row][col] = 0;
		for (int i = 0; i < 4; i++) {
			int nxr = row + d[i][0];
			int nxc = col + d[i][1];
			
			if (nxr >= 0 && nxr < N && nxc >= 0 && nxc < M)
				dfs(nxr, nxc);
		}
	}

}
