package silver;

import java.io.*;
import java.util.*;

// 백준 20055 컨베이어 벨트 위의 로봇 Silver 1

public class B20055 {
	static class Info {
		boolean robot;
		int life;
		
		Info(int life, boolean robot) {
			this.life = life;
			this.robot = robot;
		}
	}
	
	static int N, K, dead, count;
	static LinkedList<Info> belt = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			int life = Integer.parseInt(st.nextToken());
			belt.offer(new Info(life, false));
		}
		
		while (dead < K) {
			count += 1;
			belt.offerFirst(belt.pollLast());
			if (belt.get(N - 1).robot) belt.get(N - 1).robot = false;
			
			for (int i = N - 2; i >= 0; i--) {
				Info now = belt.get(i);
				Info next = belt.get(i + 1);
				if (now.robot && !next.robot && next.life != 0) {
					now.robot = false;
					next.robot = true;
					next.life -= 1;
					if (next.life == 0) dead += 1;
				}
			}
			if (belt.get(N - 1).robot) belt.get(N - 1).robot = false;
			
			Info first = belt.peekFirst();
			if (first.life != 0) {
				first.robot = true;
				first.life -= 1;
				if (first.life == 0) dead += 1;
			}
		}
		
		System.out.println(count);
		br.close();
	}

}
