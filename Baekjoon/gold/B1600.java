package gold;

import java.io.*;
import java.util.*;

// 백준 1600 말이 되고픈 원숭이 Gold4

public class B1600 {
	static int K, R, C, result;
	static int[][] map;
	static boolean[][][] visit; // r, c, jumpCount
	static int[][] walk = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] jump = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[R][C][K + 1];
		
		result = findway();
		
		System.out.println(result);
		br.close();
	}

	private static int findway() {
		LinkedList<int[]> queue = new LinkedList<>(); // r, c, lvl, jumpCnt
		queue.offer(new int[] {0, 0, 0, 0});
		visit[0][0][0] = true;
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			if (curr[0] == R - 1 && curr[1] == C - 1) return curr[2];
			
			// 사방
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + walk[i][0];
				int nc = curr[1] + walk[i][1];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0 && !visit[nr][nc][curr[3]]) {
					visit[nr][nc][curr[3]] = true;
					queue.offer(new int[] {nr, nc, curr[2] + 1, curr[3]});
				}
			}
			// 점프시도
			if (curr[3] < K) {
				for (int i = 0; i < 8; i++) {
					int nr = curr[0] + jump[i][0];
					int nc = curr[1] + jump[i][1];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0 && !visit[nr][nc][curr[3] + 1]) {
						visit[nr][nc][curr[3] + 1] = true;
						queue.offer(new int[] {nr, nc, curr[2] + 1, curr[3] + 1});
					}
				}
			}
		}
		
		return -1;
	}

}
