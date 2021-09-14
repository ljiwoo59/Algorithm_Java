package gold;

import java.io.*;
import java.util.*;

// 백준 1939 중량제한 Gold 4

public class B1939 {
	static class Bridge {
		int next, cost;
		
		Bridge(int next, int cost) {
			this.next = next;
			this.cost = cost;
		}
	}
	
	static int V, E, A, B;
	static int minW = 1, maxW, result;
	static boolean[] visit;
	static ArrayList<Bridge> [] list;
	static LinkedList<Integer> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<> ();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[start].add(new Bridge(end, cost));
			list[end].add(new Bridge(start, cost));
			maxW = Math.max(maxW, cost);
		}
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		// Binary Search 로 최대 중량 찾기
		while (minW <= maxW) {
			int midW = (minW + maxW) / 2;
			
			if (bfs(midW)) {
				result = Math.max(midW, result);
				minW = midW + 1;
			}
			else {
				maxW = midW - 1;
			}
		}
		
		System.out.println(result);
		br.close();
	}
	
	// 도착까지 탐색
	private static boolean bfs(int possW) {
		queue = new LinkedList<>();
		visit = new boolean[V + 1];
		
		queue.offer(A);
		visit[A] = true;
		
		while (!queue.isEmpty()) {
			int currNode = queue.poll();
			
			if (currNode == B) return true;
			
			for (int i = 0; i < list[currNode].size(); i++) {
				int next = list[currNode].get(i).next;
				int cost = list[currNode].get(i).cost;
				
				if (!visit[next] && possW <= cost) {
					visit[next] = true;
					queue.offer(next);
				}
			}
			
		}
		
		return false;
	}

}
