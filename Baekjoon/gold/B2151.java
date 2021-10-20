package gold;

import java.io.*;
import java.util.*;

// 백준 2151 거울 설치 Gold 4

public class B2151 {
	static class Light {
		int r, c, dir, cnt;
		
		Light(int r, int c, int dir, int cnt) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
	
	static int N, res;
	static char[][] map;
	static boolean[][][] visit;
	static int[][] d = {{-1,0}, {1, 0}, {0,-1}, {0, 1}}; // N, S, W, E
	static LinkedList<Light> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[4][N][N];
		int[] start = new int[2];
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (tmp[j] == '#') {
					start[0] = i;
					start[1] = j;
				}
			}
			map[i] = tmp;
		}

		for (int i = 0; i < 4; i++) {
			visit[i][start[0]][start[1]] = true;
			queue.offer(new Light(start[0], start[1], i, 0));
		}
		
		go: while (!queue.isEmpty()) {
			Light curr = queue.poll();
			
			while (true) {
				curr.r += d[curr.dir][0];
				curr.c += d[curr.dir][1];
				if (curr.r < 0 || curr.r >= N || curr.c < 0 || curr.c >= N) break;
				else if (map[curr.r][curr.c] == '#' && !visit[curr.dir][curr.r][curr.c]) {
					res = curr.cnt;
					break go;
				}
				else if (map[curr.r][curr.c] == '!' && !visit[curr.dir][curr.r][curr.c]) {
					visit[curr.dir][curr.r][curr.c] = true;
					int tdir = 0;
					if (curr.dir < 2) tdir = 2;
					queue.offer(new Light(curr.r, curr.c, tdir, curr.cnt + 1));
					queue.offer(new Light(curr.r, curr.c, tdir + 1, curr.cnt + 1));
				}
				else if (map[curr.r][curr.c] == '*') break;
			}
		}
		
		System.out.println(res);
		br.close();
	}

}
