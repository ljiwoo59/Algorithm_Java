package gold;

import java.io.*;
import java.util.*;

// 백준 5430 AC Gold 5

public class B5430 {
	static char[] cmd;
	static int dir; // 꺼내는 방향
	static LinkedList<Integer> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		test: for (int i = 0; i < T; i++) {
			dir = 1; // 태초에 왼쪽부터 꺼낸다
			cmd = br.readLine().toCharArray();
			queue = new LinkedList<>();
			
			int len = Integer.parseInt(br.readLine());
			
			String input = br.readLine();
			input = input.substring(1, input.length() - 1); // 괄호 빼주기
			StringTokenizer st = new StringTokenizer(input, ",");
			
			queue = new LinkedList<>();
			while (st.hasMoreTokens()) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			for (int j = 0; j < cmd.length; j++) {
				if (cmd[j] == 'R') dir *= -1;
				else {
					if (queue.isEmpty()) {
						sb.append("error\n");
						continue test;
					}
					if (dir == 1)
						queue.poll();
					else
						queue.pollLast();
				}
			}
			
			sb.append("[");
			while (!queue.isEmpty()) {
				if (dir == 1)
					sb.append(queue.poll() + ",");
				else
					sb.append(queue.pollLast() + ",");
			}
			if (sb.lastIndexOf(",") == sb.length() - 1)
				sb.setLength(sb.length() - 1);
			sb.append("]\n");
		}
		
		System.out.print(sb);
		br.close();
	}

}
