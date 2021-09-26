package gold;

import java.io.*;
import java.util.*;

// 백준 2573 빙산 Gold 4

public class B2573_2 {
	static int R, C, cnt, tot, year, result;
	static int[][] map;
	static boolean[][] visit;
	static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static LinkedList<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int now = Integer.parseInt(st.nextToken());
				map[i][j] = now;
				if (now > 0) cnt++;
			}
		}
		
		while (cnt > 0) {
			year++;
			melt();
			
			tot = 0;
			visit = new boolean[R][C];
			count: for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != 0) {
						visit[i][j] = true;
						tot = 1;
						dfs(i, j);
						break count;
					}
				}
			}

			if (cnt != tot) {
				result = year;
				break;
			}
		}
		
		System.out.println(result);
	}

	private static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + d[i][0];
			int nc = c + d[i][1];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nr][nc] && map[nr][nc] != 0) {
				tot++;
				visit[nr][nc] = true;
				dfs(nr, nc);
			}
		}
		
	}

	private static void melt() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0)
					queue.offer(new int[] {i, j});
			}
		}
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + d[i][0];
				int nc = curr[1] + d[i][1];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] > 0) {
					map[nr][nc]--;
					if (map[nr][nc] == 0) cnt--;
				}
			}
		}
	}

}
