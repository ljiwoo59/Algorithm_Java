package gold;

import java.io.*;
import java.util.*;

// 백준 3663 고득점 Gold 4

public class B3663 {
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			char[] name = br.readLine().toCharArray();
			int len = name.length;
			int res = 0;
			
			for (int j = 0; j < len; j++) {
				res += Math.min(name[j] - 'A', 'Z' - name[j] + 1);
			}
			
			int pos = Integer.MAX_VALUE;
			for (int i = 0, j; i < len; i++) {
				for (j = i + 1; j < len && name[j] == 'A'; j++);
				if (name[i] == 'A' && j == len + 1) break;
				int right = i * 2 + len - j;
				int left = i + (len - j) * 2;
				int temp = Math.min(right, left);
				pos = Math.min(temp, pos);
			}
			
			sb.append(res + pos + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}
