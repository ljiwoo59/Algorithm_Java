package gold;

import java.io.*;
import java.util.*;

// 백준 2096 내려가기 Gold 4

public class B2096 {
	static int N, minV = Integer.MAX_VALUE, maxV = Integer.MIN_VALUE;
	static int[][] minDp, maxDp;
	static int[] d = {-1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		minDp = new int[N][3];
		maxDp = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int curr = Integer.parseInt(st.nextToken());
				minDp[i][j] = curr;
				maxDp[i][j] = curr;
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				int min = minDp[i][j];
				int max = maxDp[i][j];
				minDp[i][j] = min + minDp[i-1][j];
				maxDp[i][j] = max + maxDp[i-1][j];

				for (int k = 0; k < 2; k++) {
					int nr = i - 1;
					int nc = j + d[k];
					if (nc >= 0 && nc < 3) {
						minDp[i][j] = Math.min(minDp[i][j], min + minDp[nr][nc]);
						maxDp[i][j] = Math.max(maxDp[i][j], max + maxDp[nr][nc]);
					}
				}
			}
		}
		
		for (int i = 0; i < 3; i++) {
			minV = Math.min(minV, minDp[N-1][i]);
			maxV = Math.max(maxV, maxDp[N-1][i]);
		}
		System.out.println(maxV + " " + minV);
		br.close();
	}

}
