package day5;

import java.io.*;
import java.util.*;

// 백준 2468 안전 영역 Silver 1

public class B2468 {
	static int[][] map;
	static int[][] t_arr;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int result, tmp, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		t_arr = new int[N][N];
		result = 1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= 100; i++) {
			tmp = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == i) {
						map[r][c] = 0;
					}
				}
			}
			for (int j = 0; j < N; j++) {
				System.arraycopy(map[j], 0, t_arr[j], 0, N);
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (t_arr[r][c] != 0) {
						tmp++;
						dfs(r, c);
					}
				}
			}
			result = Math.max(tmp, result);
		}
		System.out.println(result);
	}

	private static void dfs(int r, int c) {
		if (t_arr[r][c] == 0)
			return ;
		t_arr[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nxr = r + d[i][0];
			int nxc = c + d[i][1];
			
			if (nxr >= 0 && nxr < N && nxc >= 0 && nxc < N)
				dfs(nxr, nxc);
		}
	}

}
