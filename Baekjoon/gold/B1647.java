package gold;

import java.io.*;
import java.util.*;

// 백준 1647 도시 분할 계획 Gold 4

public class B1647 {
	static class Edge implements Comparable<Edge> {
		int from, to, cost;
		
		Edge (int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	static int V, E;
	static int[] parents;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(from, to, cost));
		}
		
		parents = new int[V + 1];
		Arrays.fill(parents, -1);
		
		int cnt = 0, result = 0, max = 0;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (union(curr.from, curr.to)) {
				result += curr.cost;
				max = Math.max(max, curr.cost);
				if (++cnt == V - 1) break;
			}
		}
		
		System.out.println(result - max);
		br.close();
	}

	private static boolean union(int from, int to) {
		int aRoot = find(from);
		int bRoot = find(to);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int x) {
		if (parents[x] == -1) return x;
		return parents[x] = find(parents[x]);
	}

}
