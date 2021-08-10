import java.io.*;
import java.util.*;

// 백준 1260 DFS와 BFS Silver 2

public class B1260 {
	static int N, M;
	static int[][] arr = new int[1001][1001];
	static LinkedList<Integer> queue = new LinkedList<>();
	static int[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		visit = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		dfs(start);
		
		sb.setLength(sb.length() - 1);
		sb.append("\n");
		visit = new int[N + 1];
		
		bfs(start);
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		br.close();
	}

	private static void bfs(int start) {
		sb.append(start + " ");
		for (int i = 1; i <= N; i++) {
			if (visit[i] == 0 && arr[start][i] == 1) {
				queue.offer(i);
			}
		}
		visit[start] = 1;
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			if (visit[tmp] != 1)
				sb.append(tmp + " ");
			visit[tmp] = 1;
			for (int i = 1; i <= N; i++) {
				if (visit[i] == 0 && arr[tmp][i] == 1)
					queue.offer(i);
			}
		}
	}

	private static void dfs(int start) {
		visit[start] = 1;
		sb.append(start + " ");
		for (int i = 1; i <= N; i++) {
			if (visit[i] == 1 || arr[start][i] == 0) continue;
			dfs(i);
		}
		
		
	}

}
