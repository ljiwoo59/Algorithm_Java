package gold;

import java.io.*;
import java.util.*;

// 백준 16398 행성 연결 Gold 4

public class B16398 {
	static class Star  implements Comparable<Star> {
		int from, to, cost;
		
		public Star(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Star o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int N, cnt;
	static long res;
	static int[] parents;
	static PriorityQueue<Star> edgeList = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				edgeList.offer(new Star(i, j, Integer.parseInt(st.nextToken())));
			}
		}
		
		parents = new int[N + 1];
		Arrays.fill(parents, -1);
		
		while (!edgeList.isEmpty()) {
			Star curr = edgeList.poll();
			
			if (union(curr.from, curr.to)) {
				res += curr.cost;
				if (++cnt == N - 1) break;
			}
		}
		
		System.out.println(res);
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
