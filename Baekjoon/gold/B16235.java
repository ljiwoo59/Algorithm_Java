package gold;

import java.io.*;
import java.util.*;

// 백준 16235 나무 재테크 Gold 4

public class B16235 {
	static class Tree implements Comparable<Tree> {
		int r, c, age;
		
		Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
	
	static int N, M, K;
	static int[][] A;
	static int[][] soil;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	static PriorityQueue<Tree> pq = new PriorityQueue<>();
	static LinkedList<Tree> live = new LinkedList<>();
	static LinkedList<Tree> dead = new LinkedList<>();
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		soil = new int[N][N];
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				soil[i][j] = 5;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			pq.offer(new Tree(r, c, age));
		}
		
		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		System.out.println(pq.size());
	}


	private static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				soil[i][j] += A[i][j];
			}
		}
		
	}


	private static void fall() {
		while (!live.isEmpty()) {
			Tree curr = live.poll();
			if (curr.age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int nr = curr.r + d[i][0];
					int nc = curr.c + d[i][1];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) pq.offer(new Tree(nr, nc, 1));
				}
			}
			pq.offer(curr);
		}
		
	}


	private static void summer() {
		while (!dead.isEmpty()) {
			Tree curr = dead.poll();
			soil[curr.r][curr.c] += curr.age / 2;
		}
		
	}


	private static void spring() {
		while (!pq.isEmpty()) {
			Tree curr = pq.poll();
			if (soil[curr.r][curr.c] >= curr.age) {
				soil[curr.r][curr.c] -= curr.age;
				curr.age += 1;
				live.offer(curr);
			}
			else dead.offer(curr);
		}
		
	}

}
