package day5;

import java.io.*;
import java.util.*;

// 백준 2589 보물섬 Gold 5

public class B2589 {
	static int R, C;
	static char[][] map;
	static int[][] visit;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'L')
					bfs(r, c);
			}
		}
		System.out.println(result);
		br.close();
	}

	private static void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		visit = new int[R][C];
		visit[r][c] = 1;
		queue.offer(new int[] {r, c});
		
		while (!queue.isEmpty()) {
			int nr = queue.peek()[0];
			int nc = queue.peek()[1];
			queue.poll();
			
			result = Math.max(result, visit[nr][nc] - 1);
			
			for (int i = 0; i < 4; i++) {
				int nxr = nr + d[i][0];
				int nxc = nc + d[i][1];
				
				if (nxr >= 0 && nxr < R && nxc >= 0 & nxc < C && map[nxr][nxc] == 'L' && visit[nxr][nxc] == 0) {
					queue.offer(new int[] {nxr, nxc});
					visit[nxr][nxc] = visit[nr][nc] + 1;
				}
			}
		}
	}

}
