package gold;

import java.io.*;
import java.util.*;

// 백준 2140 지뢰 찾기 Gold 5

public class B2140 {
	static int N, tot;
	static char[][] map;
	static int[][] d = {{-1, 0},{1, 0},{0, -1},{0, 1},{-1, -1},{-1, 1},{1, -1},{1, 1}}; // up down left right upleft upright downleft downright
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if (N < 3) tot = 0;
		else {
			map = new char[N][N];
			tot = (int) Math.pow(N - 2, 2);
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
	
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (i > 1 && i < N - 2 && j > 1 && j < N - 2) continue;
					boolean flag = false;
					for (int k = 0; k < 8; k++) {
						int nr = i + d[k][0];
						int nc = j + d[k][1];
						if (map[nr][nc] == '0') {
							tot--;
							flag = true;
							break;
						}
					}
					if (flag == false) {
						for (int k = 0; k < 8; k++) {
							int nr = i + d[k][0];
							int nc = j + d[k][1];
							if (map[nr][nc] != '#') {
								map[nr][nc] -= 1;
							}
						}
					}
					
				}
			}
		}
		
		System.out.println(tot);
		br.close();
	}

}
