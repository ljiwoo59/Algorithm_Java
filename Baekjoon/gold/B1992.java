import java.io.*;
import java.util.*;

// 백준 1922 네트워크 연결 Gold 4

public class B1992 {

	static class Edge implements Comparable<Edge> {
		int start, end, weight;
		
		Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int V, E;
	static int[] parents;
	static PriorityQueue<Edge> edgeList = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList.offer(new Edge(start, end, weight));
		}
		
		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
		
		int result = 0;
		while (!edgeList.isEmpty()) {
			Edge curr = edgeList.poll();
			if (union(curr.start, curr.end)) {
				result += curr.weight;
			}
		}
		
		System.out.println(result);
		br.close();
	}

	private static boolean union(int start, int end) {
		int aRoot = find(start);
		int bRoot = find(end);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

}
