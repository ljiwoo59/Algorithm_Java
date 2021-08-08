package silver;

import java.io.*;
import java.util.*;

// 백준 15900 나무 탈출 Silver 1

public class B15900_2 {
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		visit = new boolean[N + 1];
		
		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// add connections
			tree.get(x).add(y);
			tree.get(y).add(x);
		}
		
		getLength(1, 0);
		
		if (count % 2 == 0)
			System.out.println("No");
		else
			System.out.println("Yes");
		
		
		br.close();
	}

	private static void getLength(int now, int sum) {
		visit[now] = true;
		for (int connect : tree.get(now)) {
			if (visit[connect] == false) {
				getLength(connect, sum + 1);
			}
		}
		if (tree.get(now).size() == 1) // size 1 means leaf node (no children connections)
			count += sum;
	}

}
