package jungol;

import java.io.*;
import java.util.*;

// 정올 1681 해밀턴 순환회로

public class J1681 {
	static int N, result = 9999;
	static int[][] matrix;
	static boolean[] isSelected;
	static int[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N ][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isSelected = new boolean[N];
		select = new int[N];
		perm(0, 0);
		
		System.out.println(result);
	}

	private static void perm(int cnt, int now) {
		if (cnt == N - 1) {
			if (matrix[0][select[0]] == 0 || matrix[select[0]][select[1]] == 0) return;
			int totCost = 0;
			for (int i = 0; i < N - 1; i++) {
				int cost = 0;
				if (i == 0) {
					cost = matrix[0][select[0]] + matrix[select[0]][select[1]];
				}
				else cost = matrix[select[i]][select[i + 1]];
				
				if (cost == 0) return;
				totCost += cost;
				if (totCost >= result) return;
			}

			result = totCost;
			return;
		}
		
		for (int i = 1; i < N; i++) {
			if (isSelected[i]) continue;
			if (matrix[select[now]][i] == 0) continue;
			isSelected[i] = true;
			select[cnt] = i;
			perm(cnt + 1, i);
			isSelected[i] = false;
		}
	}

}
