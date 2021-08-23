import java.io.*;
import java.util.*;

// 백준 15661 링크와 스타트 Silver 1

public class B15661 {
	static int N, result = Integer.MAX_VALUE;
	static int[][] matrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		subset(0, 0);
		
		System.out.println(result);
		br.close();
	}

	private static void subset(int index, int flag) {
		if (index == N) {
			int t1 = 0, t2 = 0;
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) != 0) {
					for (int j = 0; j < N; j++) {
						if ((flag & 1 << j) != 0) t1 += matrix[i][j];
					}
				}
				else {
					for (int j = 0; j < N; j++) {
						if ((flag & 1 << j) == 0) t2 += matrix[i][j];
					}
				}
			}
			result = Math.min(result, Math.abs(t1 - t2));
			return;
		}
		subset(index + 1, flag | 1 << index);
		subset(index + 1, flag);
	}

}
