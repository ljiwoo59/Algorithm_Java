package gold;

import java.io.*;
import java.util.*;

// 백준 6497 전력난 Gold 4

public class B6497 {
	static class Road implements Comparable<Road> {
		int from, to, cost;
		
		public Road(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Road o) {
			return this.cost - o.cost;
		}
		
	}

	static int[] parents;
	static PriorityQueue<Road> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
	
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if (h == 0 && r == 0) break;
			
			int tot = 0;
			pq = new PriorityQueue<>();
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				tot += cost;
				pq.offer(new Road(from, to, cost));
			}
			
			parents = new int[h];
			Arrays.fill(parents, -1);
			
			int cnt = 0, res = 0;
			while (!pq.isEmpty()) {
				Road curr = pq.poll();
				
				if (union(curr.from, curr.to)) {
					res += curr.cost;
					if (++cnt == h - 1) break;
				}
			}
			
			sb.append(tot - res + "\n");
		}
		
		System.out.print(sb);
		br.close();
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if (parents[a] == -1) return a;
		return parents[a] = find(parents[a]);
	}

}
