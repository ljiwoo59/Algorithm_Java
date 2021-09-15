import java.io.*;
import java.util.*;

// SW 3124 최소 스패닝 트리 D 4

public class SW3124 {
	static class Edge implements Comparable<Edge> {
		int from, to, cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static int T, V, E;
	static int[] parent;
	static PriorityQueue<Edge> list = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				list.offer(new Edge(from, to, cost));
			}
			
			parent = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				parent[i] = i;
			}
			
			long result = 0;
			while (!list.isEmpty()) {
				Edge curr = list.poll();
				if (union(curr.from, curr.to)) {
					result += curr.cost;
				}
			}
			
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static boolean union(int from, int to) {
		int aRoot = find(from);
		int bRoot = find(to);
		if (aRoot == bRoot) return false;
		parent[bRoot] = aRoot;
		return true;
	}

	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

}
