package gold;

import java.io.*;
import java.util.*;

// 백준 1756 피자 굽기 Gold 5

public class B1756 {
	static int D, N;
	static int[] oven;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		oven = new int[D];
		st = new StringTokenizer(br.readLine());
		int prev = 0;
		for (int i = 0; i < D; i++) {
			int curr = Integer.parseInt(st.nextToken());
			if (i == 0) prev = curr;
			else if (prev < curr) curr = prev;
			else prev = curr;
			oven[i] = curr;
		}
		
		st = new StringTokenizer(br.readLine());
		int idx = D - 1;
		int flag = 1;
		for (int i = 0; i < N; i++) {
			int curr = Integer.parseInt(st.nextToken());
			
			if (flag == 1) {
			int flag2 = 0;
				for (int j = idx; j >= 0; j--) {
					if (oven[j] >= curr) {
						idx = j - 1;
						flag2 = 1;
						break;
					}
				}
				if (flag2 == 0) flag = 0;
			}
		}
		
		if (flag == 0) System.out.println(0);
		else System.out.println(idx + 2);
		br.close();
	}

}
