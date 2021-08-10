import java.io.*;
import java.util.*;

// 백준 4963 섬의 개수 Silver 2

public class B4963 {
	static int[][] map;
	static int row, col, result;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			
			if (row == 0 && col == 0)
				break;
			
			map = new int[row][col];
			for (int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (map[i][j] == 1) {
						result++;
						dfs(i, j);
					}
				}
			}
			sb.append(result + "\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static void dfs(int r, int c) {
		if (map[r][c] == 0)
			return ;
		map[r][c] = 0;
		for (int i = 0; i < 8; i++) {
			int nxr = r + d[i][0];
			int nxc = c + d[i][1];
			
			if (nxr >= 0 && nxr < row && nxc >= 0 && nxc < col)
				dfs(nxr, nxc);
		}
	}

}
