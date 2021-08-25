import java.io.*;
import java.util.*;

// 백준 1916 최소비용 구하기 Gold 5

public class B1916 {
	static class Edge implements Comparable<Edge> {
		int index, cost;
		
		Edge(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static int V, E, depart, dest;
	static ArrayList<Edge> [] list;
	static int[] distance;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		distance = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		list = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Edge(end, cost));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		depart = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());
		
		dijkstra();
		
		br.close();
	}

	private static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		distance[depart] = 0;
		pq.offer(new Edge(depart, 0));
		
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if (curr.index == dest) {
				System.out.println(curr.cost);
				break;
			}
			
			if (distance[curr.index] < curr.cost) continue;
			
			for (Edge edge : list[curr.index]) {
				if (distance[edge.index] > curr.cost + edge.cost) {
					distance[edge.index] = curr.cost + edge.cost;
					pq.offer(new Edge(edge.index, distance[edge.index]));
				}
			}
		}
		
		
	}

}
