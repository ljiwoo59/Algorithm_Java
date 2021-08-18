import java.io.*;
import java.util.*;

// 백준 2667 단지번호붙이기 Silver 1

public class B2667 {
	static int N, result, tot;
	static char[][] map;
	static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static ArrayList<Integer> house = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1') {
					tot = 1;
					result += 1;
					dfs(i, j);
					house.add(tot);
				}
			}
		}
		
		Collections.sort(house);
		System.out.println(result);
		for (int t : house) {
			System.out.println(t);
		}
		br.close();
	}

	private static void dfs(int r, int c) {
		map[r][c] = '0';
		for (int i = 0; i < 4; i++) {
			int nr = r + d[i][0];
			int nc = c + d[i][1];
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '1') {
				tot += 1;
				dfs(nr, nc);
			}
		}
		
	}

}
