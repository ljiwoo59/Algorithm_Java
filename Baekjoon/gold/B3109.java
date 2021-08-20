package day8;

import java.io.*;
import java.util.*;

// 백준 3109 빵집 Gold 2

public class B3109 {
	static int R, C, flag, result;
	static char[][] map;
	static int[][] d = {{-1, 1}, {0, 1}, {1, 1}}; // right-up, right, right-down
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			flag = 0;
			dfs(i, 0);
		}
		System.out.println(result);
		br.close();
	}

	private static void dfs(int r, int c) {
		if (c == C - 1) {
			flag = 1;
			result += 1;
			return;
		}
		for (int i = 0; i < 3; i++) {
			int nr = r + d[i][0];
			int nc = c + d[i][1];
			if (nr >= 0 && nr < R && c >= 0 && c < C && map[nr][nc] == '.') {
				map[nr][nc] = 'x';
				dfs(nr, nc);
				if (flag == 1)
					return;
			}
		}
	}

}
