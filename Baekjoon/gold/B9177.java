package gold;

import java.io.*;
import java.util.*;

// 백준 9177 단어 섞기 Gold 5

public class B9177 {
	static int T;
	static boolean[][] dp; // r: one c: two
	static LinkedList<int[]> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] one = st.nextToken().toCharArray();
			char[] two = st.nextToken().toCharArray();
			char[] fin = st.nextToken().toCharArray();
			int res = 0;
			
			queue = new LinkedList<>();
			dp = new boolean[one.length + 1][two.length + 1];
			queue.offer(new int[] {0, 0});
			while (!queue.isEmpty()) {
				int[] curr = queue.poll();
				int currIdx = curr[0] + curr[1];
				
				if (currIdx == fin.length) {
					res = 1;
					break;
				}
				
				int nr = curr[0] + 1;
				int nc = curr[1] + 1;
				
				if (nr <= one.length && fin[currIdx] == one[nr - 1] && !dp[nr][curr[1]]) {
					dp[nr][curr[1]] = true;
					queue.offer(new int[] {nr, curr[1]});
				}
				
				if (nc <= two.length && fin[currIdx] == two[nc - 1] && !dp[curr[0]][nc]) {
					dp[curr[0]][nc] = true;
					queue.offer(new int[] {curr[0], nc});
				}
			
			}

			sb.append("Data set " + t + ": ");
			if (res == 1) sb.append("yes\n");
			else sb.append("no\n");
		}

		System.out.print(sb);
		br.close();
	}

}
