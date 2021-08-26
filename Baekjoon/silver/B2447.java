package silver;

import java.io.*;
import java.util.*;

// 백준 2447 별 찍기 Silver 1

public class B2447 {
	static int N;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = ' ';
			}
		}
		
		star(N, 0, 0);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}

	private static void star(int n, int r, int c) {
		if (n == 1) {
			map[r][c] = '*';
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(i == 1 && j == 1)) star(n / 3, r + (n / 3) * i, c + (n / 3) * j);
			}
		}
	}

}
