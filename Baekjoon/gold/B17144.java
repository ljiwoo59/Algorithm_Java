package gold;

import java.io.*;
import java.util.*;

// 백준 17144 미세먼지 안녕! Gold 4

public class B17144 {
	static int R, C, T, total;
	static int mr, mc;
	static int map[][];
	static int tmp[][];
	static int d[][] = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // right, up, left, down

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int now = Integer.parseInt(st.nextToken());
				if (now == -1) {
					mr = i;
					mc = j;
				}
				else if (now > 0) total += now;
				map[i][j] = now;
			}
		}
		
		while (T != 0) {
			--T;
			// 확산
			tmp = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) {
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int nr = i + d[k][0];
							int nc = j + d[k][1];
							if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
								tmp[nr][nc] += map[i][j] / 5;
								cnt++;
							}
						}
						map[i][j] -= (map[i][j] / 5) * cnt;
					}
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] += tmp[i][j];
				}
			}

			// 순환
			air(mr - 1, mc + 1, 0, 0, 0);
			air(mr, mc + 1, 1, 0, 0);
		}
		
		System.out.println(total);
		br.close();
	}

	private static void air(int r, int c, int stat, int dir, int prev) {
		if ((r == mr && c == mc) || (r == mr - 1 && c == mc))  {
			total -= prev;
			return;
		}
		int now = map[r][c];
		if (stat == 0) {
			for (int i = dir; i < 4; i++) {
				int nr = r + d[i][0];
				int nc = c + d[i][1];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					air(nr, nc, stat, i, now);
					break;
				}
			}
		}
		else if (stat == 1) {
			for (int i = dir; i < 4; i++) {
				int nr = r + d[i][0] * -1;
				int nc = c + d[i][1] * -1;
				if (i % 2 == 0) {
					nr = r + d[i][0];
					nc = c + d[i][1];
				}
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					air(nr, nc, stat, i, now);
					break;
				}
			}
		}
		map[r][c] = prev;
	}

}
