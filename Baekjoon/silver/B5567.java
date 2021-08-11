package day5;

import java.io.*;
import java.util.*;

// 백준 5567 결혼식 Silver 1

public class B5567 {
	static int N, M, result;
	static boolean[][] r;
	static boolean[] visit;
	static LinkedList<Integer> f = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		r = new boolean[N + 1][N + 1];
		visit = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			r[x][y] = true;
			r[y][x] = true;
		}

		visit[1] = true;
		for (int i = 1; i <= N; i++) {
			if (r[1][i]) {
				f.offer(i);
				result++;
				visit[i] = true;
			}
		}
		
		while (!f.isEmpty()) {
			int now = f.poll();
			for (int i = 1; i <= N; i++) {
				if (r[now][i] && !visit[i]) {
					result++;
					visit[i] = true;
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}

}
