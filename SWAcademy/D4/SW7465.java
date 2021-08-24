import java.io.*;
import java.util.*;

// SW 7465 창용 마을 무리의 개수 D 4

public class SW7465 {

	
	static int V, E;
	static int[] parents;
	static LinkedList<int[]> list = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				list.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			parents = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				parents[i] = i;
			}
			
			int cnt = 0;
			while (!list.isEmpty()) {
				int[] curr = list.poll();
				if (union(curr[0], curr[1])) cnt++;
			}
			
			sb.append("#" + t + " " + (V - cnt) + "\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static boolean union(int i, int j) {
		int aRoot = find(i);
		int bRoot = find(j);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
		
	}

	private static int find(int i) {
		if (parents[i] == i) return i;
		return parents[i] = find(parents[i]);
	}

}
