package gold;

import java.io.*;
import java.util.*;

// 백준 9935 문자열 폭발 Gold 4

public class B9935 {
	static String input, boom;
	static LinkedList<Character> stack = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		input = br.readLine();
		boom = br.readLine();
		
		for (int i = 0; i < input.length(); i++) {
			char curr = input.charAt(i);
			int r = find(curr);
			stack.offerLast(curr);
			if (r != -1) {
				if (r == boom.length() - 1 && stack.size() >= boom.length()) {
					check();
				}
			} 
		}
		
		if (stack.isEmpty()) System.out.println("FRULA");
		else {
			for (char c : stack) {
				sb.append(c);
			}
			System.out.println(sb);
		}
		br.close();
	}

	private static void check() {
		LinkedList<Character> tmp = new LinkedList<>();
		for (int i = boom.length() - 1; i >= 0; i--) {
			if (!stack.isEmpty() && stack.peekLast() == boom.charAt(i)) {
				tmp.offerLast(stack.pollLast());
			} else {
				while (!tmp.isEmpty())
					stack.offerLast(tmp.pollLast());
				return;
			}
		}
	}

	static private int find(char s) {
		for (int i = 0; i < boom.length(); i++) {
			if (s == boom.charAt(i))
				return i;
		}
		return -1;
	}
}
