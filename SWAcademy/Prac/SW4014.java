import java.io.*;
import java.util.*;

// SW 4014 활주로 건설 모의 역량테스트

public class SW4014 {
	static int T, N, X;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			// 가로
			row : for (int r = 0; r < N; r++) {
				int prev = map[r][0];
				int cnt = 1;
				for (int c = 1; c < N; c++) {
					if (map[r][c] == prev) cnt++;
					else if (map[r][c] == prev + 1 && cnt >= X) {
						prev = map[r][c];
						cnt = 1;
					}
					else if (map[r][c] == prev - 1) {
						for (int k = c + 1; k < c + X; k++) {
							if (k >= N || map[r][k] != map[r][c]) continue row;
						}
						c = c + X - 1;
						prev = map[r][c];
						cnt = 0;
					}
					else continue row;
				}
				result++;
			}
			
			// 세로
			col : for (int c = 0; c < N; c++) {
				int prev = map[0][c];
				int cnt = 1;
				for (int r = 1; r < N; r++) {
					if (map[r][c] == prev) cnt++;
					else if (map[r][c] == prev + 1 && cnt >= X) {
						prev = map[r][c];
						cnt = 1;
					}
					else if (map[r][c] == prev - 1) {
						for (int k = r + 1; k < r + X; k++) {
							if (k >= N || map[k][c] != map[r][c]) continue col;
						}
						r = r + X - 1;
						prev = map[r][c];
						cnt = 0;
					}
					else continue col;
				}
				result++;
			}
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}
