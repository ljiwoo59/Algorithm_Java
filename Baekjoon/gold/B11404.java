package gold;

import java.io.*;
import java.util.*;

// 백준 11404 플로이드 Gold 4

public class B11404 {
	static int N, M;
	static int[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N][N];
		
		for(int i=0; i < N; i++) {
			Arrays.fill(dist[i], 10000001);
		}
		
		for (int i=0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			dist[from][to] = Math.min(dist[from][to], cost);
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				if (i == k) continue;
				for(int j=0;j<N;j++) {
					if (i == j || j == k) continue;
					if (dist[i][k] == 10000001 || dist[k][j] == 10000001) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		for(int i=0; i<N;i++) {
			for(int j=0; j<N;j++) {
				int curr = dist[i][j];
				if (curr == 10000001) curr = 0;
				sb.append(curr + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}

}
