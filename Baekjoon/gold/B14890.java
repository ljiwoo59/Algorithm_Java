package gold;

import java.io.*;
import java.util.*;

// 백준 14890 경사로 Gold 3

public class B14890 {
	static int N, L, res;
	static int[][] map;
	static boolean[] stair;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < N; r++) {
			int prev = map[r][0];
			boolean flag = true;
			stair = new boolean[N];
			for (int c = 0; c < N; c++) {
				if (!flag) break;
				if (map[r][c] == prev) continue;
				if (map[r][c] > prev + 1 || map[r][c] < prev - 1) {
					flag = false;
					break;
				}
				if (map[r][c] == prev + 1) {
					if (stair[c - 1]) {
						flag = false;
						break;
					}
					stair[c - 1] = true;
					flag = check(r, c - 2, prev, 1, 1, 0);
				}
				else if (map[r][c] == prev - 1) {
					if (stair[c]) {
						flag = false;
						break;
					}
					stair[c] = true;
					flag = check(r, c + 1, prev - 1, 1, -1, 0);
				}
				prev = map[r][c];
			}
			if (flag) res++;
		}
		
		for (int c = 0; c < N; c++) {
			int prev = map[0][c];
			boolean flag = true;
			stair = new boolean[N];
			for (int r = 0; r < N; r++) {
				if (!flag) break;
				if (map[r][c] == prev) continue;
				if (map[r][c] > prev + 1 || map[r][c] < prev - 1) {
					flag = false;
					break;
				}
				if (map[r][c] == prev + 1) {
					if (stair[r - 1]) {
						flag = false;
						break;
					}
					stair[r - 1] = true;
					flag = check(r - 2, c, prev, 1, 1, 1);
				}
				else if (map[r][c] == prev - 1) {
					if (stair[r]) {
						flag = false;
						break;
					}
					stair[r] = true;
					flag = check(r + 1, c, prev - 1, 1, -1, 1);
				}
				prev = map[r][c];
			}
			if (flag) res++;
		}
		
		System.out.println(res);
		br.close();
	}

	private static boolean check(int r, int c, int status, int cnt, int dir, int rc) {
		if (dir == 1) {
			while (cnt != L) {
				if (c < 0 || r < 0) return false;
				if (map[r][c] != status) return false;
				if (rc == 0) {
					if (stair[c]) return false;
					stair[c] = true;
				}
				else {
					if (stair[r]) return false;
					stair[r] = true;
				}
				cnt++;
				if (rc == 0) c--;
				else r--;
			}
		}
		else {
			while (cnt != L) {
				if (c >= N || r >= N) return false;
				if (map[r][c] != status) return false;
				if (rc == 0) {
					if (stair[c]) return false;
					stair[c] = true;
				}
				else {
					if (stair[r]) return false;
					stair[r] = true;
				}
				cnt++;
				if (rc == 0) c++;
				else r++;
			}
		}
		return true;
	}

}
