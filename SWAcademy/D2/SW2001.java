import java.io.*;
import java.util.*;

// SW 2001 파리 퇴치 D2

public class SW2001 {
	static int N,M;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0;
					for (int i2 = i; i2 < i + M; i2++) {
						for (int j2 = j; j2 < j + M; j2++) {
							sum += arr[i2][j2];
						}
					}
					if (sum > max)
						max = sum;
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}

}
