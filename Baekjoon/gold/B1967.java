package gold;

import java.io.*;
import java.util.*;

// 백준 1967 트리의 지름 Gold 4

public class B1967 {
	static class Edge {
		int end, cost;
		
		Edge(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	
	static int N, maxLeaf, maxD;
	static boolean[] dist;
	static LinkedList<Edge>[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new LinkedList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		dist = new boolean[N + 1];
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].offer(new Edge(end, cost));
			list[end].offer(new Edge(start, cost));
		}

		dist[1] = true;
		findMax(1, 0, false);
		dist[maxLeaf] = false;
		findMax(maxLeaf, 0, true);
		
		System.out.println(maxD);
		br.close();
	}

	private static void findMax(int now, int cost, boolean flag) {
		for (Edge e : list[now]) {
			if (dist[e.end] == flag) {
				dist[e.end] = !flag;
				findMax(e.end, cost + e.cost, flag);
			}
		}
		if (cost > maxD) {
			maxD = cost;
			maxLeaf = now;
		}
	}

}
