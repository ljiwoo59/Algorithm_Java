package day5;

import java.io.*;
import java.util.*;

// 백준 1987 알파벳 Gold 4

public class B1987 {
	static int R, C, result = 1;
	static int d[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[26];
		
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}

		dfs(0, 0, 0);
		System.out.println(result);
		br.close();
	}

	private static void dfs(int r, int c, int cnt) {
		if (visit[map[r][c] - 'A']) {
			result = Math.max(result, cnt);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nxr = r + d[i][0];
			int nxc = c + d[i][1];
			
			if (nxr >= 0 && nxr < R && nxc >= 0 && nxc < C) {
				visit[map[r][c] - 'A'] = true;
				dfs(nxr, nxc, cnt + 1);
				visit[map[r][c] - 'A'] = false;
			}
		}
	}

}
