import java.io.*;
import java.util.*;

// 백준 1753 최단 경로 Gold 5

public class B1753_2 {
	static class Edge implements Comparable<Edge> {
		int end, weight;
		
		Edge(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	
	static int V, E, start, INF = Integer.MAX_VALUE;
	static ArrayList<Edge>[] list;
	static int[] distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		list = new ArrayList[V + 1];
		
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Edge(end, weight));
		}

		distance = new int[V + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		dijkstra();
		
		for (int i = 1; i <= V; i++) {
			if (distance[i] == INF) {
				System.out.println("INF");
				continue;
			}
			System.out.println(distance[i]);
		}
		
		br.close();
		
	}

	private static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0)); // 최초에 시작점을 넣어준다
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll(); // 꺼낸 정점은 최소 거리를 가진다고 확정
			
			if (distance[curr.end] < curr.weight) continue; // 만약 지금 꺼낸 정점까지의 거리가 최소 거리보다 크면 다음 정점을 고려하기위해 스킵한다
			
			for (Edge edge : list[curr.end]) {
				if (distance[edge.end] > curr.weight + edge.weight) {
					distance[edge.end] = curr.weight + edge.weight;
					pq.offer(new Edge(edge.end, distance[edge.end])); // 지금 꺼낸 정점의 인접 정점까지의 최소거리를 갱신했을 때만 넣는다
				}
			}
		}
		
	}

}
