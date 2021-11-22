package gold;

import java.io.*;
import java.util.*;

// 백준 1240 노드사이의 거리 Gold 5

public class B1240 {
	static int N, M;
	static int[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int[N + 1][N + 1];
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dist[s][e] = dist[e][s]= c;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k) continue;
				for (int j = 1; j <= N; j++) {
					if (i == j || j == k) continue;
					if (dist[i][j] != 0) continue;
					if (dist[i][k] == 0 || dist[k][j] == 0) continue;
					dist[i][j] = dist[j][i] = dist[i][k] + dist[k][j];
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(dist[s][e] + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}
