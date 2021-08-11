package silver;

import java.io.*;
import java.util.*;

// 백준 1389 케빈 베이컨의 6단계 법칙 Silver 1

public class B1389 {
	static int N, M;
	static boolean[][] arr;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;
	static LinkedList<int[]> queue = new LinkedList<>();
	static int[] person;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new boolean[N + 1][N + 1];
		person = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = true;
			arr[y][x] = true;
		}
		
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			visit = new boolean[N + 1];
			queue.offer(new int [] {i, 0});
			while (!queue.isEmpty()) {
				int prevl = queue.peek()[1];
				int now = queue.poll()[0];
				sum += prevl;
				visit[now] = true;
				for (int j = 1; j <= N; j++) {
					if (arr[now][j] && !visit[j]) {	
						queue.offer(new int[] {j, prevl + 1});
						visit[j] = true;
					}
				}
			}
			person[i] = sum;
		}
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (person[i] < min) {
				min = person[i];
				result = i;
			}
		}
		System.out.println(result);
		br.close();
	}

}
