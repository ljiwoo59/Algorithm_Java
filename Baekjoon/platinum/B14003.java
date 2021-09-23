package platinum;

import java.io.*;
import java.util.*;

// 백준 14003 가장 긴 증가하는 부분 수열 5 Platinum 5

public class B14003 {
	static int[] nums, LIS, p, result;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		nums = new int[N]; // 모든 원소의 값은 다르다
		LIS = new int[N]; // 해당 길이를 증가수열 중 맨 끝을 최소값으로 유지
		p = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int size = 0; // LIS 에 채워진 원소 수
		for (int i = 0; i < N; i++) {
			if (size == 0 || LIS[size - 1] < nums[i]) {
				LIS[size++] = nums[i];
				p[i] = size;
			}
			else {
				// 중복값이 없으므로 탐색 실패: 음수값 => 삽입 위치로 환산
				int temp = Arrays.binarySearch(LIS, 0, size, nums[i]);
				if (temp < 0) temp = -temp - 1;
				LIS[temp] = nums[i];
				p[i] = temp + 1;
			}
		}

		sb.append(size + "\n");
		backtrace(N, size);
		sb.setLength(sb.length() - 1);
		
		System.out.println(sb);
		br.close();
	}

	private static void backtrace(int idx, int num) {
		if (idx == 0) return;
		if (p[idx - 1] == num) {
			backtrace(idx - 1, num - 1);
			sb.append(nums[idx - 1] + " ");
		}
		else backtrace(idx - 1, num);
	}

}
