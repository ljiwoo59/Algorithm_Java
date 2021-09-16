package gold;

import java.io.*;
import java.util.*;

// 백준 14503 청소기 Gold 5

public class B14503 {
	static int R, C, result;
	static int dir, posR, posC;
	static int[][] map;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // N W S E

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		st = new StringTokenizer(br.readLine());
		posR = Integer.parseInt(st.nextToken());
		posC = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		robot();
		
		System.out.println(result);
		br.close();
	}

	private static void robot() {
		main: while (true) {
			if (map[posR][posC] == 0) {
				map[posR][posC] = 2 + result;
				result++;
			}
			
			int idx = 0;
			while (true) {
				dir -= 1;
				if (dir == -1) dir = 3;
				if (idx == 3) {
					int nr = posR + d[dir][0];
					int nc = posC + d[dir][1];
					if (map[nr][nc] == 0) {
						posR = nr;
						posC = nc;
						break;
					}
					nr = posR - d[dir][0];
					nc = posC - d[dir][1];
					if (map[nr][nc] != 1) {
						posR = nr;
						posC = nc;
						idx = 0;
						continue;
					}
					else return;
				}

				int nr = posR + d[dir][0];
				int nc = posC + d[dir][1];
				if (map[nr][nc] == 0) {
					posR = nr;
					posC = nc;
					break;
				}
				
				idx++;
			}
		}
		
	}

}
