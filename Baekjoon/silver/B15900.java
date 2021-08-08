package silver;

import java.io.*;
import java.util.*;

// 백준 15900 나무 탈출 Silver 1

public class B15900 {
	static int[] parr, len;
	static boolean[] leaf;
	static LinkedList<int[]> tmp = new LinkedList<int[]>();
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		parr = new int[N + 1];
		len = new int[N + 1];
		parr[1] = 1;
		leaf = new boolean[N + 1];
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (parr[x] == 0 && parr[y] == 0) // 둘다 누가 부모인지 모를 경우 tmp 에 저장
				tmp.offer(new int[] {x, y});
			else if (parr[x] != 0) // x 가 부모를 가지고 있으면 y 는 x 의 자식
				parr[y] = x;
			else // y 가 부모를 가지고 있으면 x 는 y 의 자식
				parr[x] = y;
		}
		while (!tmp.isEmpty()) { // tmp 에 넣어둔 아이들 부모 찾기
			if (parr[tmp.peek()[0]] != 0)
				parr[tmp.peek()[1]] = tmp.poll()[0];
			else
				parr[tmp.peek()[0]] = tmp.poll()[1];
		}
		for (int i = 1; i <= N; i++) { // leaf node 찾기 (false 이면 누구의 부모도 아님)
			leaf[parr[i]] = true;
		}
		for (int i = 1; i <= N; i++) {
			if (leaf[i] == true) {
				len[i] = getLength(i, 1);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (leaf[i] == false) {
				count += len[parr[i]];
			}
		}

		if (count % 2 == 0)
			System.out.println("No");
		else
			System.out.println("Yes");
		
		
		br.close();
	}

	private static int getLength(int num, int i) { // 중복 계산 방지
		int count = i;
		if (num == 1)
			return count;
		if (len[num] == 0)
			count = getLength(parr[num], count + 1);
		else
			count = len[num] + 1;
		return count;
	}

}
