package gold;

import java.io.*;
import java.util.*;

// 백준 13549 숨바꼭질 3 Gold 5

public class B13549 {
	static class Pos implements Comparable<Pos> {
		int s, time;

		Pos(int s, int time) {
			this.s = s;
			this.time = time;
		}
		
		@Override
		public int compareTo(Pos o) {
			return this.time - o.time;
		}
	}
	
	static int S, B, res;
	static boolean[] visit;
	static PriorityQueue<Pos> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		visit = new boolean[1000001];
		
		pq.offer(new Pos(S, 0));
		while (true) {
			Pos curr = pq.poll();
			visit[curr.s] = true;
			
			if (curr.s == B) {
				res = curr.time;
				break;
			}
			
			if (curr.s - 1 >= 0 && !visit[curr.s - 1]) pq.offer(new Pos(curr.s - 1, curr.time + 1));
			if (curr.s + 1 <= B && !visit[curr.s + 1]) pq.offer(new Pos(curr.s + 1, curr.time + 1));
			if (curr.s * 2 <= 100000 && !visit[curr.s * 2]) pq.offer(new Pos(curr.s * 2, curr.time));
		}
		
		System.out.println(res);
		br.close();
	}
}
