package gold;

import java.io.*;
import java.util.*;

// 백준 9019 DSLR GOLD 5

public class B9019 {
	static int T, a, b;
	static boolean[] visit;
	static LinkedList<Op> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			queue = new LinkedList<>();
			visit = new boolean[10000];
			
			queue.offer(new Op(a, ""));
			while (!queue.isEmpty()) {
				Op curr = queue.poll();
				if (curr.num == b) {
					sb.append(curr.cmd + "\n");
					break;
				}
				for (int i = 0; i < 4; i++) {
					operation(curr, i);
				}
				
			}
		}
		System.out.print(sb);
		br.close();
	}

	private static void operation(Op curr, int i) {
		int tmp = 0;
		if (i == 0) {
			tmp = curr.num * 2;
			if (tmp > 9999) {
				tmp %= 10000;
			}
			if (!visit[tmp]) {
				visit[tmp] = true;
				queue.offer(new Op(tmp, curr.cmd + "D"));
			}
		}
		else if (i == 1) {
			if (curr.num == 0)
				tmp = 9999;
			else
				tmp = curr.num - 1;
			if (!visit[tmp]) {
				visit[tmp] = true;
				queue.offer(new Op(tmp, curr.cmd + "S"));
			}
		}
		else if (i == 2) {
			tmp = (curr.num % 1000) * 10 + curr.num / 1000;
			if (!visit[tmp]) {
				visit[tmp] = true;
				queue.offer(new Op(tmp, curr.cmd + "L"));
			}
		}
		else if (i == 3) {
			tmp = (curr.num % 10) * 1000 + curr.num / 10;
			if (!visit[tmp]) {
				visit[tmp] = true;
				queue.offer(new Op(tmp, curr.cmd + "R"));
			}
		}
	}

	
}

class Op {
	int num;
	String cmd;
	
	Op(int num, String cmd) {
		this.num = num;
		this.cmd = cmd;
	}
}
