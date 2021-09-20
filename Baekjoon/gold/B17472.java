package gold;

import java.io.*;
import java.util.*;

// 백준 17472 다리 만들기 2 Gold 2

/*
 * 1. 입력 받은 섬의 정보를 바탕으로 섬마다 번호를 붙여줌 (DFS)
 * 2. 각 섬에서 출발해서 도착 가능한 다른 섬에 다리를 건설해 봄 (BFS)
 * 3. 모든 섬을 연결하는 다리길이의 최소값 찾음 (Kruskal : Union-Find)
 */

public class B17472 {
	static class Island implements Comparable<Island>{
		int r, c, val; // 초반엔 섬번호 지만 나중에 다리 길이
		
		Island(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}

		@Override
		public int compareTo(Island o) {
			return this.val - o.val;
		}
	}
	
	static int R, C, N; // N: 섬 번호
	static int[] parent;
	static int[][] map;
	static int[][] d = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static LinkedList<Island> list = new LinkedList<>(); // 섬 정보 저장
	static PriorityQueue<Island> pq = new PriorityQueue<>(); // 다리길이 기준으로 정렬
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		// 1. 섬 -1 표시
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = -1; // 섬번호를 1번부터 사용할거라서 
				}
			}
			
		}
		
		// 2. 섬 넘버링 (1 ~ N)
		N = 1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1) {
					dfs(i, j);
					N++;
				}
			}
		}
		
		// 3. 각 섬들을 잇는 다리 건설
		buildBridge();
		
		// 4. 각 섬들을 최소 비용으로 연결해주는 다리 짓기 (MST)
		parent = new int[N];
		Arrays.fill(parent, -1);
		System.out.println(mst());
	}

	private static int mst() {
		int sum = 0;

		while (!pq.isEmpty()) {
			Island curr = pq.poll(); // 시작섬, 끝섬, 길이
	
			// 다리 길이가 2 이상이고 시작섬과 도착섬이 다르면
			if (curr.val != 1 && union(curr.r, curr.c)) {
				sum += curr.val; // 다리 길이 누적
			}
		}
		
		// 모든섬 연결 확인
		int rootCnt = 0; // -1 값 개수 체크
		for (int i = 1; i < N; i++) {
			if (parent[i] == -1) rootCnt++;
		}
		
		return (rootCnt == 1) ? sum : -1;
	}

	// 섬들 간의 다리 만들어 보기 : 큐에서 섬 정보를 꺼내 다리 만들어 보기
	private static void buildBridge() {
		while (!list.isEmpty()) {
			Island curr = list.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + d[i][0];
				int nc = curr.c + d[i][1];
				
				int length = 0; // 다리 길이
				while (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (map[nr][nc] != 0) {
						if (curr.val < map[nr][nc]) { // 작은번호 섬 -> 큰번호 섬 방향으로만 건설 (1->2와 2->1는 동일)
							pq.offer(new Island(map[curr.r][curr.c], map[nr][nc], length)); //시작섬 번호, 끝섬 번호, 다리 길이
						}
						break;
					}
					else { // 바다이면 같은 방향으로 계속 다리 건설
						length++;
						nr += d[i][0];
						nc += d[i][1];
					}
				}
			}
		}
		
	}

	private static void dfs(int r, int c) {
		list.offer(new Island(r, c, N));
		map[r][c] = N;
		for (int i = 0; i < 4; i++) {
			int nr = r + d[i][0];
			int nc = c + d[i][1];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == -1)
				dfs(nr, nc);
		}
	}

	private static int find(int a) {
		if (parent[a] == -1) return a;
		return parent[a] = find(parent[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		parent[bRoot] = aRoot;
		return true;
	}
}
