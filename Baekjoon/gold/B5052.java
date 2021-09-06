package gold;

import java.io.*;
import java.util.*;

// 백준 5052 전화번호 목록 Gold 4

public class B5052 {
	static int n;
	static ArrayList<String> number;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		test: for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			number = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				number.add(br.readLine());
			}
			Collections.sort(number);
			
			for (int i = 0; i < n - 1; i++) {
				if (number.get(i + 1).startsWith(number.get(i))) {
					sb.append("NO\n");
					continue test;
				}
			}
			sb.append("YES\n");
		}
		
		System.out.print(sb);
		br.close();
	}

}
