package day8;

import java.io.*;
import java.util.*;

// 백준 2580 스도쿠 Gold 4

public class B2580 {
	static int N = 9, flag = 0;
	static int[][] map;
	static LinkedList<int[]> zero = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 0) zero.offer(new int[] {i, j});
				map[i][j] = n;
			}
		}
		
		sudoku();
		
		StringBuilder sb = new StringBuilder();
		for (int[] r : map) {
			for (int c : r) {
				sb.append(c + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		System.out.print(sb);

		br.close();
	}

	private static void sudoku() {
		if (zero.isEmpty()) {
			flag = 1;
			return;
		}
		
		int[] curr = zero.poll();
		for (int i = 1; i <= 9; i++) {
			if (flag == 0 && check(curr, i)) {
				map[curr[0]][curr[1]] = i;
				sudoku();
			}
		}
		
		if (flag == 1)
			return;
		map[curr[0]][curr[1]] = 0;
		zero.addFirst(curr);
	}
	
	private static boolean check(int[] curr, int num) {
		// row check
		for (int r = 0; r < N; r++) {
			if (map[r][curr[1]] == num)
				return false;
		}
		
		// col check
		for (int c = 0; c < N; c++) {
			if (map[curr[0]][c] == num)
				return false;
		}
		
		// square check
		for (int i = (curr[0] / 3) * 3; i < 3 + (curr[0] / 3) * 3; i++) {
			for (int j = (curr[1] / 3) * 3; j < 3 + (curr[1] / 3) * 3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}
		
		return true;
	}
}
