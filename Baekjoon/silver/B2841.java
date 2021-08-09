package day4;

import java.io.*;
import java.util.*;

// 백준 2841 외계인의 기타 연주 Silver 1

public class B2841 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		LinkedList<LinkedList<Integer>> line = new LinkedList<>();
		
		for (int i = 0; i <= 6; i++) {
			line.add(new LinkedList<Integer>());
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			LinkedList<Integer> now = line.get(n);

			while (!now.isEmpty() && now.peekLast() > p) {
				now.removeLast();
				count++;
			}
			if (!now.isEmpty() && now.peekLast() < p) {
					now.addLast(p);
					count++;
			}
			if (now.isEmpty()) {
				now.addLast(p);
				count++;
			}
		}
		System.out.println(count);
	}

}
