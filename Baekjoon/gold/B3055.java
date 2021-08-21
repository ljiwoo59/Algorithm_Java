import java.io.*;
import java.util.*;

// 백준 3055 탈출 Gold 4

public class B3055 {
	static int R, C, time;
	static char[][] map;
	static int[] pos, dest;
	static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static LinkedList<int[]> water = new LinkedList<>(); // r, c, time
	static LinkedList<int[]> beaver = new LinkedList<>(); // r, c, time
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*')
					water.offer(new int[] {i, j, 0});
				else if (map[i][j] == 'S')
					beaver.offer(new int[] {i, j, 0});
				else if (map[i][j] == 'D')
					dest = new int[] {i, j};
			}
		}
		
		if (escape())
			System.out.println(time);
		else
			System.out.println("KAKTUS");
		br.close();
	}

	private static boolean escape() {
		while (!beaver.isEmpty()) {
			while (!beaver.isEmpty() && time == beaver.peek()[2]) { // 같은 시간대 이동 가능 비버
				int[] b_curr = beaver.poll();
				
				if (b_curr[0] == dest[0] && b_curr[1] == dest[1]) // 도착하면
					return true;
				
				if (map[b_curr[0]][b_curr[1]] == '*') // 시도한 길이 물에 차는 경우
					continue;
				
				for (int i = 0; i < 4; i++) {
					int nr = b_curr[0] + d[i][0];
					int nc = b_curr[1] + d[i][1];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && (map[nr][nc] == '.' || map[nr][nc] == 'D')) {
						map[nr][nc] = 'S';
						beaver.offer(new int[] {nr, nc, b_curr[2] + 1});
					}
				}
			}
			
			while (!water.isEmpty() && time == water.peek()[2]) { // 같은 시간대 이동 가능 물
				int[] w_curr = water.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = w_curr[0] + d[i][0];
					int nc = w_curr[1] + d[i][1];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && (map[nr][nc] != 'X' && map[nr][nc] != 'D' && map[nr][nc] != '*')) {
						map[nr][nc] = '*';
						water.offer(new int[] {nr, nc, w_curr[2] + 1});
					}
				}
			}
			
			time++;
			
		}
		return false; // 도착하지 않으면
	}
}
