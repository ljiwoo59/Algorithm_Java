package silver;

import java.io.*;
import java.util.*;

// 백준 11053 가장 긴 증가하는 부분 수열 Silver 2

public class B11053 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[size];
		
		for (int i = 0; i < size; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] <= dp[j]) // 현재 수 보다 작은 수가 있는 지를 찾고 
					dp[i] = dp[j] + 1; 				   // 해당 작은 수가 순열을 이루고 있는경우 현재 수에 추가
			} 										   // 최종적으로 자신 포함 제일 긴 순열을 담음
		}
		int max = 1;
		for (int i : dp) {
			if (i > max)
				max = i;
		}
		System.out.println(max);
		br.close();
	}
}
