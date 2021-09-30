import java.io.*;
import java.util.*;

// SW 1953 탈주범 검거 [모의 역량테스트]

public class SW1953 {
	static class Pipe {
		int r, c, type, time;
		boolean[] avail;
		
		Pipe(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
			type = map[r][c];
			
			check(type);
		}

		private void check(int t) {
			avail = new boolean[4];
			Arrays.fill(avail, false);
			
			if (t == 1) Arrays.fill(avail, true);
			else if (t == 2) avail[0] = avail[1] = true;
			else if (t == 3) avail[2] = avail[3] = true;
			else if (t == 4) avail[0] = avail[3] = true;
			else if (t == 5) avail[1] = avail[3] = true;
			else if (t == 6) avail[1] = avail[2] = true;
			else avail[0] = avail[2] = true;
		}
	}
	
	static int T, R, C, mr, mc, L;
	static int[][] map;
	static boolean visit[][];
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우 
	static LinkedList<Pipe> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			mr = Integer.parseInt(st.nextToken());
			mc = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			visit = new boolean[R][C];
			queue = new LinkedList<>();
			visit[mr][mc] = true;
			queue.offer(new Pipe(mr, mc, 1));
			
			while (!queue.isEmpty()) {
				Pipe now = queue.poll();
				ans++;
				
				if (now.time >= L) continue;
				for (int i = 0; i < 4; i++) {
					if (!now.avail[i]) continue;
					int nr = now.r + d[i][0];
					int nc = now.c + d[i][1];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nr][nc] && map[nr][nc] != 0) {
						Pipe next = new Pipe(nr, nc, now.time + 1);
						if (i == 0 && next.avail[1] || i == 1 && next.avail[0] || i == 2 && next.avail[3] || i == 3 && next.avail[2]) {
							visit[nr][nc] = true;
							queue.offer(next);
						}
					}
				}
			}
			
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}
