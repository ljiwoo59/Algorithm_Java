package gold;

import java.io.*;
import java.util.*;

// 백준 1941 소문난 칠공주 Gold 3

public class B1941 {
	static int R = 5, C = 5, result;
	static char[][] map;
	static boolean[][] visit;
	static int[] select;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		select = new int[7];
		comb(0, 0, 0);

		System.out.println(result);
		br.close();
	}

	private static void comb(int cnt, int start, int yCnt) {
		if (yCnt >= 4) return;
		if (cnt == 7) {
			visit = new boolean[R][C];
			for (int i = 0; i < 7; i++) {
				visit[select[i] / 5][select[i] % 5] = true;
			}
			connect(select[0] / 5, select[0] % 5);
			for (int i = 6; i >= 0; i--) {
				if (visit[select[i] / 5][select[i] % 5]) return;
			}
			
			result++;
			return;
		}
		
		for (int i = start; i < 25; i++) {
			select[cnt] = i;
			if (map[i / 5][i % 5] == 'Y') comb(cnt + 1, i + 1, yCnt + 1);
			else comb(cnt + 1, i + 1, yCnt);
		}
	}

	private static void connect(int r, int c) {
		visit[r][c] = false;
		for (int i = 0; i < 4; i++) {
			int nr = r + d[i][0];
			int nc = c + d[i][1];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && visit[nr][nc] == true)
				connect(nr, nc);
		}
	}


}
