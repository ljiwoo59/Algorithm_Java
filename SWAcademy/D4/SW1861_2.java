package day3;

import java.io.*;
import java.util.*;

//SW 1861 정사각형 방 D 4

public class SW1861_2 {

	static int[][] arr, visit;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}} ;
	static int N;
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visit = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (visit[r][c] == 0)
						check(r, c);
				}
				
			}
			
			int max = -1;
			int no = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (visit[r][c] > max) {
						max = visit[r][c];
						no = arr[r][c];
					}
					else if (max == visit[r][c])
						no = Math.min(no, arr[r][c]);
				}
			}
			System.out.println("#" + t + " " + no + " " + max);
		}

	}

	private static void check(int r, int c) {
		visit[r][c] = 1;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + d[i][0];
			int nc = c + d[i][1];
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == arr[r][c] + 1) {
				check(nr, nc);
				visit[r][c] = visit[nr][nc] + 1;
			}
		}
	}


}
