package gold;

import java.io.*;
import java.util.*;

// 백준 1976 여행 가자 Gold 4

public class B1976 {
	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int curr = Integer.parseInt(st.nextToken());
				if (curr == 1) union(i, j);
			}
		}
		
		String res = "YES";
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		for (int i = 1; i < M; i++) {
			int curr = Integer.parseInt(st.nextToken());
			if (find(start) != find(curr)) {
				res = "NO";
				break;
			}
		}
		
		System.out.println(res);
		br.close();
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			if (aRoot > bRoot) parent[aRoot] = bRoot;
			else parent[bRoot] = aRoot;
		}
		
	}

	private static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}

}
