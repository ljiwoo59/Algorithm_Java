package gold;

import java.io.*;
import java.util.*;

// 백준 1245 농장 관리 Gold 5

public class B1245 {
	static int R, C, flag, res;
	static int[][] map;
	static int[][] visit;
	static int[][] d = {{-1,0},{1,0},{0,-1},{0,1},{-1,1},{-1,-1},{1,-1},{1,1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visit[i][j] == -1) continue;
				flag = 0;
				visit[i][j] = -1;
				dfs(i, j);
				if (flag == 0) res += 1;
			}
		}
		
		System.out.println(res);
		br.close();
	}

	private static void dfs(int i, int j) {
		for (int k = 0; k < 8; k++) {
			int nr = i + d[k][0];
			int nc = j + d[k][1];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if (visit[nr][nc] != -1 && map[i][j] == map[nr][nc]) {
					visit[nr][nc] = -1;
					dfs(nr, nc);
				}
				else if (map[nr][nc] > map[i][j]) flag = 1;
			}
		}
		
	}

}
