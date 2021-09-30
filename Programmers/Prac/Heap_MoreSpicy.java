import java.util.*;

// 프로그래머스 Heap > 더 맵게

public class Heap_MoreSpicy {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3};
		int K = 11;
		
		int result = Solution(scoville, K);

		System.out.println(result);
	}

	private static int Solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int res = -1;
		
		for (int i : scoville) {
			pq.offer(i);
		}
		
		int cnt = 0;
		while (!pq.isEmpty()) {
			int first = pq.poll();
			if (first >= K) return cnt;
			if (pq.isEmpty()) break;
			int second = pq.poll();
			pq.offer(first + second * 2);
			cnt++;
		}
		
		return res;
	}

}
