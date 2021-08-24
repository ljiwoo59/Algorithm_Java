import java.io.*;
import java.util.*;

// SW 3289 서로소 집합 D 4

public class SW3289 {
	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(st.nextToken()); // 원소 개수
			M = Integer.parseInt(st.nextToken()); // 연산 개수
			
			make();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (op == 0) union(a, b);
				else if (op == 1) {
					if (find(a) == find(b)) sb.append(1);
					else sb.append(0);
				}
			}
			
			System.out.println("#" + t + " " + sb);
		}
		br.close();

	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return;
		parents[bRoot] = aRoot;
		return;
		
	}

	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

}
