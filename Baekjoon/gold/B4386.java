package gold;

import java.io.*;
import java.util.*;

// 백준 4386 별자리 만들기 Gold 4

public class B4386 {
	static class Star implements Comparable<Star> {
		int from, to;
		double x, y, cost;
		
		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public Star(int from, int to, double  cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Star o) {
			double diff = this.cost - o.cost;
			int res = 0;
			if (diff > 0) res = 1;
			else if (diff < 0) res = -1;
			return res;
		}
	
	}

	static int N, cnt;
	static double res;
	static int[] parents;
	static ArrayList<Star> list = new ArrayList<>();
	static PriorityQueue<Star> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			list.add(new Star(x, y));
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				pq.offer(new Star(i, j, diff(list.get(i).x, list.get(j).x, list.get(i).y, list.get(j).y)));
			}
		}
		
		parents = new int[N + 1];
		Arrays.fill(parents, -1);
		
		while (!pq.isEmpty()) {
			Star curr = pq.poll();
			
			if (union(curr.from, curr.to)) {
				res += curr.cost;
				if (++cnt == N - 1) break;
			}
		}
		
		System.out.printf("%.2f", res);
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

	private static double diff(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}
