package gold;

import java.io.*;
import java.util.*;

// 백준 1956 운동 Gold 4

public class B1956 {
	static int V, E;
	static int INF = 987654321;
	static int[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[V + 1][V + 1];
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				dist[i][j] = INF;
			}
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		int minV = INF;
		for (int i = 1; i <= V; i++) {
			minV = Math.min(minV, dist[i][i]);
		}
		
		if (minV != INF) System.out.println(minV);
		else System.out.println(-1);
		br.close();
	}

}
