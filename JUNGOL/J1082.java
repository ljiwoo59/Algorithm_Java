package jungol;

import java.io.*;
import java.util.*;

// 정올 1082 화염에서탈출

public class J1082 {
	static class Pos {
		int r, c, time;
		
		Pos(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	static int R, C;
	static Pos end;
	static char[][] map;
	static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static LinkedList<Pos> player = new LinkedList<>();
	static LinkedList<Pos> fire = new LinkedList<>();
	static String result = "impossible";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (tmp[j] == 'S') {
					player.offer(new Pos(i, j, 0));
					tmp[j] = '1';
				}
				else if (tmp[j] == 'D') end = new Pos(i, j, 0);
				else if (tmp[j] == '*') fire.offer(new Pos(i, j, 0));
				map[i][j] = tmp[j];
			}
		}
		
		while (!player.isEmpty()) {
			Pos nowPlayer = player.poll();
			
			if (nowPlayer.r == end.r && nowPlayer.c == end.c) {
				result = Integer.toString(nowPlayer.time);
				break;
			}
			
			//fire
			while (!fire.isEmpty() && fire.peekFirst().time == nowPlayer.time) {
				Pos nowFire = fire.poll();
				for (int i = 0; i < 4; i++) {
					int nr = nowFire.r + d[i][0];
					int nc = nowFire.c + d[i][1];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && (map[nr][nc] == '.' || map[nr][nc] == '1')) {
						map[nr][nc] = '*';
						fire.offer(new Pos(nr, nc, nowFire.time + 1));
					}
				}
			}
			
			//player
			for (int i = 0; i < 4; i++) {
				int nr = nowPlayer.r + d[i][0];
				int nc = nowPlayer.c + d[i][1];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && (map[nr][nc] == '.' || map[nr][nc] == 'D')) {
					map[nr][nc] = '1';
					player.offer(new Pos(nr, nc, nowPlayer.time + 1));
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}

}
