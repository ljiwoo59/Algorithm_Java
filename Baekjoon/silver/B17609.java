package silver;

import java.io.*;
import java.util.*;

// 백준 17609 회문 Silver 1

public class B17609 {
	static char[] input;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			input = br.readLine().toCharArray();
			result = palindrome();
			sb.append(result + "\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static int palindrome() {
		int left = 0;
		int right = input.length - 1;
		
		while (left <= right) {
			if (input[left] != input[right]) {
				int r = Math.min(pseudo(left + 1, right), pseudo(left, right - 1));
				return r;
			}
			left++;
			right--;
		}
		
		return 0;
	}

	private static int pseudo(int left, int right) {
		while (left <= right) {
			if (input[left] != input[right]) return 2;
			left++;
			right--;
		}
		return 1;
	}

}
