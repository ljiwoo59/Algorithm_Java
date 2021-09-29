package gold;

import java.io.*;
import java.util.*;

// 백준 1194 달이 차오른다, 가자. Gold 1

public class B1194 {
	
	static int R, C, result = -1;
	static char[][] map;
	static boolean[][][] visit;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static LinkedList<int[]> queue = new LinkedList<>(); // r, c, key, lvl
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[1 << 6][R][C]; // 열쇠 개수
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			if (queue.isEmpty()) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '0') {
						queue.offer(new int[] {i, j, 0, 0});
						visit[0][i][j] = true;
						break;
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] curr = queue.poll(); // r, c, key, lvl
			
			if (map[curr[0]][curr[1]] == '1') { // 도착
				result = curr[3];
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + d[i][0];
				int nc = curr[1] + d[i][1];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '#' || visit[curr[2]][nr][nc]) continue;
				if (map[nr][nc] == '.' || map[nr][nc] == '1' || map[nr][nc] == '0') {
					visit[curr[2]][nr][nc] = true;
					queue.offer(new int[] {nr, nc, curr[2], curr[3] + 1});
				}
				else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
					if ((curr[2] & (1 << map[nr][nc] - 'A')) != 0) {
						visit[curr[2]][nr][nc] = true;
						queue.offer(new int[] {nr, nc, curr[2], curr[3] + 1});
					}
				}
				else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					visit[curr[2] | (1 << map[nr][nc] - 'a')][nr][nc] = true;
					queue.offer(new int[] {nr, nc, curr[2] | (1 << map[nr][nc] - 'a'), curr[3] + 1});
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}

}
