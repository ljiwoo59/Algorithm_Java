import java.io.*;
import java.util.*;

// 백준 2178 미로 탐색 Silver 1

public class B2178 {
	static int R, C, result;
	static char[][] map;
	static int[][] visit;
	static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static LinkedList<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new int[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		queue.offer(new int[] {0, 0, 0});
		visit[0][0] = 1;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (curr[0] == R - 1 && curr[1] == C - 1) {
				result = curr[2];
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + d[i][0];
				int nc = curr[1] + d[i][1];
				
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '1' && visit[nr][nc] == 0) {
					visit[nr][nc] = 1;
					queue.offer(new int[] {nr, nc, curr[2] + 1});
				}
			}
		}
		
		System.out.println(result + 1);
		br.close();
	}

}
