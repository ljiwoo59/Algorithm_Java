import java.io.*;
import java.util.*;

// 백준 4485 녹색 옷 입은 애가 젤다지? Gold 4

public class B4485 {
	static class Info implements Comparable<Info>{
		int r, c, cost;
		
		Info(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		public int compareTo(Info o) {
			return this.cost - o.cost;
		}
	}
	
	static int N, pcnt = 1;
	static int[][] map, distance;
	static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			map = new int[N][N];
			distance = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Arrays.fill(distance[i], Integer.MAX_VALUE);
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("Problem " + pcnt +": ");
			
			dijkstra();
			
			pcnt++;
		}
		
		System.out.print(sb);
		br.close();
	}

	private static void dijkstra() {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		distance[0][0] = map[0][0];
		pq.offer(new Info(0, 0, distance[0][0]));
		
		while (!pq.isEmpty()) {
			Info curr = pq.poll();
			
			if (curr.r == N - 1 && curr.c == N - 1) {
				sb.append(curr.cost + "\n");
				break;
			}
			
			if (distance[curr.r][curr.c] < curr.cost) continue;
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + d[i][0];
				int nc = curr.c + d[i][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && distance[nr][nc] > curr.cost + map[nr][nc]) {
					distance[nr][nc] = curr.cost + map[nr][nc];
					pq.offer(new Info(nr, nc, distance[nr][nc]));
				}
			}
		}
		
		
	}

}
