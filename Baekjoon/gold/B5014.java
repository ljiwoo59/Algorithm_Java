package gold;

import java.io.*;
import java.util.*;

// 백준 5014 스타트링크 Gold 5

public class B5014 {
	static int F, S, G, U, D, flag; // total, start, dest, up, down, possible
	static boolean[] visit;
	static LinkedList<int[]> queue = new LinkedList<>(); // curr-level, cnt
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		visit = new boolean[F + 1];
		visit[S] = true;
		queue.offer(new int[] {S, 0});
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (curr[0] == G) {
				flag = 1;
				System.out.println(curr[1]);
				break;
			}
			
			if (curr[0] + U <= F && !visit[curr[0] + U]) {
				visit[curr[0] + U] = true;
				queue.offer(new int[] {curr[0] + U, curr[1] + 1});
			}
			if (curr[0] - D >= 1 && !visit[curr[0] - D]) {
				visit[curr[0] - D] = true;
				queue.offer(new int[] {curr[0] - D, curr[1] + 1});
			}
		}
		
		if (flag != 1)
			System.out.println("use the stairs");
		br.close();
	}

}
