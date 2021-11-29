package gold;

import java.io.*;
import java.util.*;

// 백준 14500 테트로미노 Gold 5

public class B14500 {
	static int R, C, res;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				visit[i][j] = true;
				dfs(i, j, 1, 0);
				visit[i][j] = false;
				// ㅏ, ㅗ, ㅜ, ㅓ
				if (i + 2 < R && j + 1 < C) res = Math.max(res, map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1]);
				if (i - 1 >= 0 && j + 2 < C) res = Math.max(res, map[i][j] + map[i - 1][j + 1] + map[i][j + 1] + map[i][j + 2]);
				if (i + 1 < R && j + 2 < C) res = Math.max(res, map[i][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i][j + 2]);
				if (i + 2 < R && j - 1 >= 0) res = Math.max(res, map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j - 1]);
			}
		}
		
		System.out.println(res);
		br.close();
	}

	private static void dfs(int i, int j, int now, int tot) {
		tot += map[i][j];
		if (now == 4) {
			res = Math.max(res, tot);
			return;
		}
		for (int k = 0; k < 4; k++) {
			int nr = i + d[k][0];
			int nc = j + d[k][1];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && visit[nr][nc] == false) {
				visit[nr][nc] = true;
				dfs(nr, nc, now + 1, tot);
				visit[nr][nc] = false;
			}
		}
		
	}

}
