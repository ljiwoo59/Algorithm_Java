import java.io.*;
import java.util.*;

// SW 1865 동철이의 일 분배 D 4

public class SW1865 {
	static int T, N;
	static double max;
	static double[][] pos;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			pos = new double[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					pos[i][j] = Double.parseDouble(st.nextToken()) / 100.0;
				}
			}
			
			isSelected = new boolean[N];
			max = 0.0;
			perm(0, 1.0);
			
			System.out.printf("%s%d %.6f\n", "#", t, max * 100.0);
		}

	}

	private static void perm(int cnt, double tot) {
		if (cnt == N) {
			max = Math.max(max, tot);
			return;
		}
		if (tot <= max) return;
		for (int i = 0; i < N; i++) {
			if (isSelected[i] == true) continue;
			isSelected[i] = true;
			perm(cnt + 1, tot * pos[i][cnt]);
			isSelected[i] = false;
		}
	}

}
