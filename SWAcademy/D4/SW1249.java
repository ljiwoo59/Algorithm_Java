import java.io.*;
import java.util.*;

// SW 1249 보급로 D 4

public class SW1249 {
	static class Pos implements Comparable<Pos> {
		int r, c, cost;
		
		Pos(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pos o) {
			return this.cost - o.cost;
		}
	}
	
	static int T, N;
	static char[][] map;
	static int[][] dist;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static PriorityQueue<Pos> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			dist[0][0] = 0;
			
			pq = new PriorityQueue<>();
			pq.offer(new Pos(0, 0, 0));
			
			int result = 0;
			while (!pq.isEmpty()) {
				Pos curr = pq.poll();
				
				if (curr.r == N - 1 && curr.c == N - 1) {
					result = curr.cost;
					break;
				}
				
				if (dist[curr.r][curr.c] < curr.cost) continue;
				
				for (int i = 0; i < 4; i++) {
					int nr = curr.r + d[i][0];
					int nc = curr.c + d[i][1];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && dist[nr][nc] > curr.cost + (map[nr][nc] - '0')) {
						dist[nr][nc] = curr.cost + (map[nr][nc] - '0');
						pq.offer(new Pos(nr, nc, dist[nr][nc]));
					}
				}
			}
			
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}
