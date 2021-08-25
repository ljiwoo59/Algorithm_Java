import java.io.*;
import java.util.*;

// 백준 1753 최단 경로 Gold 5

public class B1753 {
	static class Edge {
		int end, weight;
		
		Edge(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	
	
	static int V, E, start, INF = Integer.MAX_VALUE;
	static ArrayList<Edge>[] list;
	static int[] distance;
	static boolean[] visited;

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

		visited = new boolean[V + 1];
		distance = new int[V + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		int curr = 0;
		
		for (int i = 0; i <= V; i++) {
			int min = INF;
			for (int j = 0; j <= V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					curr = j;
				}
			}
			
			visited[curr] = true;
			
			for (Edge edge : list[curr]) {
				if (!visited[edge.end] && distance[edge.end] > min + edge.weight) {
					distance[edge.end] = min + edge.weight;
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (distance[i] == INF) {
				System.out.println("INF");
				continue;
			}
			System.out.println(distance[i]);
		}
		
		br.close();
		
	}

}
