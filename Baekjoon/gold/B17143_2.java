package gold;

import java.io.*;
import java.util.*;

// 백준 17143 낚시왕 Gold 2

public class B17143_2 {
	static class Shark implements Comparable<Shark> {
		int r, c, speed, dir, size, check;
		
		Shark(int r, int c, int speed, int dir, int size, int check) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
			this.check = check;
		}

		@Override
		public int compareTo(Shark o) {
			return this.r - o.r;
		}
	}
	
	static int R, C, M, result;
	static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // up down right left
	static LinkedList<Shark>[] colShark;
	static Shark[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		colShark = new LinkedList[C];
		for (int i = 0; i < C; i++) {
			colShark[i] = new LinkedList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			
			if (d == 0 || d == 1) s %= ((R - 1) * 2);
			else if (d == 2 || d == 3) s %= ((C - 1) * 2);
			Shark shark = new Shark(r, c, s, d, z, 0);
			colShark[c].offer(shark);
		}

		for (int i = 0; i < C; i++) {
			// catch
			if (!colShark[i].isEmpty()) {
				Collections.sort(colShark[i]);
				Shark s = colShark[i].poll();
				result += s.size;
			}
			
			// shark move
			map = new Shark[R][C];
			for (int j = 0; j < C; j++) {
				while (!colShark[j].isEmpty() && colShark[j].peekFirst().check == i) {
					Shark s = colShark[j].poll();
					int idx = 0;
					while (idx < s.speed) {
						int nr = s.r + d[s.dir][0];
						int nc = s.c + d[s.dir][1];
						if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
							s.r = nr;
							s.c = nc;
							idx++;
						}
						else {
							if (s.dir == 0) s.dir = 1;
							else if (s.dir == 1) s.dir = 0;
							else if (s.dir == 2) s.dir = 3;
							else if (s.dir == 3) s.dir = 2;
						}
					}
					if (map[s.r][s.c] != null && map[s.r][s.c].size < s.size) {
						colShark[s.c].remove(colShark[s.c].indexOf(map[s.r][s.c]));
						map[s.r][s.c] = s;
						s.check++;
						colShark[s.c].offer(s);
					}
					else if (map[s.r][s.c] == null) {
						map[s.r][s.c] = s;
						s.check++;
						colShark[s.c].offer(s);
					}
				}
			}
		}
		System.out.println(result);
		br.close();
	}

}