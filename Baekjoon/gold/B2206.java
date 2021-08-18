import java.io.*;
import java.util.*;

// 백준 2206 벽 부수고 이동하기 Gold 4

public class B2206 {
	static int R, C, result = Integer.MAX_VALUE;
	static char[][] map;
	static int[][][] visit; // 0 : no break, 1: break
	static int[][] d = {{1,0}, {0,1}, {-1,0}, {0,-1}}; // down right up left
	static LinkedList<int[]> queue = new LinkedList<>(); // r, c, cnt, wall flag
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		queue.offer(new int[] {0, 0, 0, 0});
		visit = new int[R][C][2];
		findway();
		
		if (result == Integer.MAX_VALUE)
			result = -1;
		System.out.println(result);
		br.close();

	}

	private static void findway() {
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (curr[0] == R - 1 && curr[1] == C - 1) {
				result = Math.min(result, curr[2] + 1);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + d[i][0];
				int nc = curr[1] + d[i][1];
				
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (map[nr][nc] == '1' && curr[3] == 0 && visit[nr][nc][1] == 0) {
						visit[nr][nc][1] = 1;
						queue.offer(new int[] {nr, nc, curr[2] + 1, 1});
					}
					else if (map[nr][nc] == '0' && visit[nr][nc][curr[3]] == 0) {
						visit[nr][nc][curr[3]] = 1;
						queue.offer(new int[] {nr, nc, curr[2] + 1, curr[3]});
					}
				}
			}
			
		}
		
	}
	
}
