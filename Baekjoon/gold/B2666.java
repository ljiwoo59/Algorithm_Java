package gold;

import java.io.*;
import java.util.*;

public class B2666 {
	static int closet, num, result = Integer.MAX_VALUE;
	static int[] order;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		closet = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(br.readLine());
		order = new int[num];
		for (int i = 0; i < num; i++) {
			order[i] = Integer.parseInt(br.readLine());
		}

		opening(0, first, second, 0);
		
		System.out.println(result);
		br.close();
	}

	private static void opening(int index, int first, int second, int cnt) {
		if (index == num) {
			result = Math.min(result, cnt);
			return;
		}
		
		int curr = order[index];
		if (curr == first || curr == second) opening(index + 1, first, second, cnt);
		else {
			if (curr == 1) opening(index + 1, 1, second, cnt + (first - 1));
			else if (curr == closet) opening(index + 1, first, closet, cnt + Math.abs(closet - second));
			else {
				opening(index + 1, curr, second, cnt + Math.abs(curr - first));
				opening(index + 1, first, curr, cnt + Math.abs(second - curr));
			}
		}
	}

}
