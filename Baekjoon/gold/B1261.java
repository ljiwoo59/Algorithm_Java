package gold;

import java.io.*;
import java.util.*;

// 백준 1261 알고스팟 Gold 4

public class B1261 {
	static class Loc implements Comparable<Loc>{
		int r, c, cost;
		
		Loc(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		public int compareTo(Loc o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int R, C, result;
	static char[][] map;
	static int[][] dist;
	static int[][] d = {{-1,0}, {1, 0}, {0,-1}, {0,1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		dist = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		dijkstra();
		
		System.out.println(result);
		br.close();
	}

	private static void dijkstra() {
		PriorityQueue<Loc> pq = new PriorityQueue<>();
		pq.offer(new Loc(0, 0, 0));
		dist[0][0] = 0;
		
		while (!pq.isEmpty()) {
			Loc curr = pq.poll();
			
			if (curr.r == R - 1 && curr.c == C - 1) {
				result = curr.cost;
				break;
			}
			
			if (curr.cost > dist[curr.r][curr.c]) continue;
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + d[i][0];
				int nc = curr.c + d[i][1];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && 
						dist[nr][nc] > dist[curr.r][curr.c] + (map[nr][nc] - '0')) {
					dist[nr][nc] = dist[curr.r][curr.c] + (map[nr][nc] - '0');
					pq.offer(new Loc(nr, nc, dist[nr][nc]));
				}
			}
		}
	}


}
