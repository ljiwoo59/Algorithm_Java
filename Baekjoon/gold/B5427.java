package gold;

import java.io.*;
import java.util.*;

// 백준 5427 불 Gold 4

public class B5427 {
	static class Pos {
		int r, c, time;
		
		Pos(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	static int T, R, C;
	static char[][] map;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static LinkedList<Pos> fire = new LinkedList<>();
	static LinkedList<Pos> player = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			fire.clear();
			player.clear();
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			for (int r = 0; r < R; r++) {
				map[r] = br.readLine().toCharArray();
				for (int c = 0; c < C; c++) {
					if (map[r][c] == '*') fire.offer(new Pos(r, c, 0));
					else if (map[r][c] == '@') player.offer(new Pos(r, c, 0));
				}
			}

			int res = 0;
			while (!player.isEmpty()) {
				Pos curr = player.poll();
				if (curr.r == 0 || curr.r == R - 1 || curr.c == 0 || curr.c == C - 1) {
					res = curr.time + 1;
					break;
				}
				while (!fire.isEmpty()) {
					if (fire.peekFirst().time != curr.time) break;
					Pos currF = fire.poll();
					for (int i = 0; i < 4; i++) {
						int nr = currF.r + d[i][0];
						int nc = currF.c + d[i][1];
						if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != '#' && map[nr][nc] != '*') {
							map[nr][nc] = '*';
							fire.offer(new Pos(nr, nc, currF.time + 1));
						}
					}
				}
				for (int i = 0; i < 4; i++) {
					int nr = curr.r + d[i][0];
					int nc = curr.c + d[i][1];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
						map[nr][nc] = '@';
						player.offer(new Pos(nr, nc, curr.time + 1));
					}
				}
			}
			
			if (res == 0) sb.append("IMPOSSIBLE\n");
			else sb.append(res + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}