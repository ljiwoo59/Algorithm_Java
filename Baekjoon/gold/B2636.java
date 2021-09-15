package gold;

import java.io.*;
import java.util.*;

// 백준 2636 치즈 Gold 5

public class B2636 {
	static int R, C, now, cnt, time;
	static int[][] map;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int curr = Integer.parseInt(st.nextToken());
				map[i][j] = curr;
				if (curr == 1) cnt++;
				
			}
		}
		
		while(cnt != 0) {
			time++;
			now = cnt;
			cheese();
		}

		System.out.println(time);
		System.out.println(now);
		br.close();
	}

	private static void cheese() {
		LinkedList<int[]> queue = new LinkedList<>(); // r, c
		visit = new boolean[R][C];
		
		queue.offer(new int[] {0,0});
		visit[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] curr= queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + d[i][0];
				int nc = curr[1] + d[i][1];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nr][nc]) {
					visit[nr][nc] = true;
					if (map[nr][nc] == 1) {
						cnt--;
						map[nr][nc] = 0;
					}
					else queue.offer(new int[] {nr, nc});
				}
			}
		}
		
	}

}
