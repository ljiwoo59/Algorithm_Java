package gold;

import java.io.*;
import java.util.*;

// 백준 2075 N번째 큰 수 Gold 5

public class B2075_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
				if (pq.size() > N)
					pq.poll();
			}
		}
		System.out.println(pq.peek());
		br.close();
	}

}
