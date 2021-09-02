package gold;

import java.io.*;
import java.util.*;

// 백준 14891 톱니바퀴 Gold 5

public class B14891 {
	static LinkedList<Integer> [] gear = new LinkedList[4];
	static int T;
	static int[] done = new int[4];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			char[] tmp = br.readLine().toCharArray(); // 1: S, 0: N
			gear[i] = new LinkedList<>();
			for (int j = 0; j < 8; j++) {
				gear[i].offer(tmp[j] - '0');
			}
		}
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int which = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()); // 1: clockwise, -1: counterclockwise
			
			Arrays.fill(done, 0);
			dfs(which, dir);
			
		}
		
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (gear[i].peekFirst() == 1)
				result += Math.pow(2, i);
		}

		System.out.println(result);
		br.close();
	}

	private static void dfs(int which, int dir) {
		int left = gear[which].get(6);
		int right = gear[which].get(2);
		
		if (dir == 1) gear[which].offerFirst(gear[which].pollLast());
		else gear[which].offerLast(gear[which].pollFirst());
		done[which] = 1;
		
		if (which + 1 < 4 && done[which + 1] != 1 && right != gear[which + 1].get(6))
			dfs(which + 1, dir * (-1));
		if (which - 1 >= 0 && done[which - 1] != 1 && left != gear[which - 1].get(2))
			dfs(which - 1, dir * (-1));
	}

}
