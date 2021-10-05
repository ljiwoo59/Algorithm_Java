package gold;

import java.io.*;
import java.util.*;

// 백준 15961 회전 초밥 Gold 4

public class B15961 {
	static int N, d, k, c; // 접시 수, 초밥 가짓 수, 연속해서 먹는 접시 수, 쿠폰 번호
	static int cnt, result;
	static int[] sushi;
	static int[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		visit = new int[d + 1];
		sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < k; i++) {
			if (visit[sushi[i]]++ == 0) cnt++;
		}
		result = cnt;
		if (visit[c] == 0) result++;
		
		for (int i = 1; i < N; i++) {
			int coupon = 0;
			if (--visit[sushi[i - 1]] == 0) cnt--;
			if (++visit[sushi[(i + k - 1) % N]] == 1) cnt++;
			if (visit[c] == 0) coupon++;
			
			result = Math.max(result, cnt + coupon);
		}
		
		System.out.println(result);
		br.close();
	}

}
