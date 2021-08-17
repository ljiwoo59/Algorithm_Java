import java.io.*;
import java.util.*;

// 백준 1461 도서관 Gold 5

public class B1461 {
	static int N, M, result;
	static LinkedList<Integer> walk_p;
	static LinkedList<Integer> walk_n;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		walk_p = new LinkedList<>();
		walk_n = new LinkedList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num < 0)
				walk_n.offer(num);
			else if (num > 0)
				walk_p.offer(num);
			max = Math.max(max, Math.abs(num));
		}
		
		Collections.sort(walk_p);
		Collections.sort(walk_n);
		
		while (!walk_p.isEmpty()) {
			result += walk_p.peekLast() * 2;
			for (int i = 0; i < M; i++) {
				walk_p.pollLast();
			}
		}
		
		while (!walk_n.isEmpty()) {
			result += Math.abs(walk_n.peekFirst()) * 2;
			for (int i = 0; i < M; i++) {
				walk_n.pollFirst();
			}
		}
		
		result -= max;
		
		System.out.println(result);
		br.close();
	}

}
