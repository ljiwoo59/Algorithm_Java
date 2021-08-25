import java.io.*;
import java.util.*;

// SW 1251 하나로 D 4

public class SW1251 {
	static class Island implements Comparable<Island> {
		int x, y;
		double cost;
		
		Island() {}
		
		Island(int x, int y, double cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		public int compareTo(Island o) {
			if (this.cost < o.cost) return -1;
			else if (this.cost > o.cost) return 1;
			return 0;
		}

	}
	
	static int N;
	static double E, result;
	static Island[] list;
	static ArrayList<Island> edge;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new Island[N];
			for (int i = 0; i < N; i++) {
				list[i] = new Island();
			}
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if (i == 0)
						list[j].x = Integer.parseInt(st.nextToken());
					else
						list[j].y = Integer.parseInt(st.nextToken());
				}
			}
			E = Double.parseDouble(br.readLine());
			
			edge = new ArrayList<>();
			for (int i = 0; i < N - 1; i++) {
				for (int j = 1; j < N; j++) {
					edge.add(new Island(i, j, E * (Math.pow(list[i].x - list[j].x, 2) + Math.pow(list[i].y - list[j].y, 2))));
				}
			}
			
			Collections.sort(edge);
			
			parents = new int[N];
			for (int i = 0; i < N; i++) {
				parents[i] = i;
			}
			
			result = 0.0;
			for (Island island : edge) {
				if (union(island.x, island.y)) result += island.cost;
			}
			
			System.out.print("#" + t + " ");
			System.out.printf("%.0f\n", result);
			
		}
		br.close();
	}

	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot) return false;
		parents[yRoot] = xRoot;
		return true;
	}

	private static int find(int x) {
		if (parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}

}
