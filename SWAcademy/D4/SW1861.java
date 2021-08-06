package day3;

import java.io.*;
import java.util.*;

// SW 1861 정사각형 방 D 4

public class SW1861 {

	static int[][] arr;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}} ;
	static int N;
	static int count;
	static int max;
	static int min_num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			max = Integer.MIN_VALUE;
			min_num = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					count = 0;
					findway(r, c, arr[r][c] - 1);
					if (count == max && arr[r][c] < min_num) {
						min_num = arr[r][c];
					}
					else if (count > max) {
						max = count;
						min_num = arr[r][c];
					}
					
				}
				
			}
			System.out.println("#" + t + " " + min_num + " " + max);
		}

	}

	private static void findway(int row, int col, int num) {
		if (arr[row][col] != num + 1)
			return ;
		count++;
		for (int i = 0; i < 4; i++) {
			int nr = row + d[i][0];
			int nc = col + d[i][1];
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < N)
				findway(nr, nc, arr[row][col]);
		}
		
		
	}

}
