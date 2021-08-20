package day7;

import java.io.*;
import java.util.*;

// 백준 12865 평범한 배낭 Gold 5

public class B12865 {
	static int N, K;
	static int[][] item; // weight, value
	static int[][] dp; // col: bag wegiht, row: item index -> [row][col] : 현재 인덱스까지 본 아이템들 중 현재 가방 무게에 최적(가치가 높은)으로 넣을 수 있는 값어치
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		item = new int[N + 1][2];
		dp = new int[N + 1][K + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			item[i][0] = Integer.parseInt(st.nextToken());
			item[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) { // item
			for (int j = 1; j <= K; j++) { // bag weight
				dp[i][j] = dp[i - 1][j]; // 현재 item 을 고려하기 전 현재 무게에 넣은 물건들의 최대 값어치 (현재 item 을 안 넣었을 떄의 최대값)
				if (j >= item[i][0]) { // item 을 넣을 수 있으면
					int prev = dp[i - 1][j - item[i][0]]; // 현재 item 을 고려하기 전에 현재 무게에 넣은 물건들 중 현재 item 을 넣기 위해 item 무게 뺸 값어치
					dp[i][j] = Math.max(dp[i][j], prev + item[i][1]); // 결국 현재 item 을 넣지 않은 값어치 vs 넣은 값어치
				}
			}
		}
		
		System.out.println(dp[N][K]);
		br.close();
	}

}
