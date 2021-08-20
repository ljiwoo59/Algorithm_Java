package day8;

import java.io.*;
import java.util.*;

// 백준 1759 암호 만들기 Gold 5

public class B1759 {
	static int L, C;
	static String[] alpha, select;
	static String[] vowl = {"a", "e", "i", "o", "u"};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		alpha = new String[C];
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken();
		}
		select = new String[L];
		Arrays.sort(alpha);
		comb(0, 0, 0, 0);
	}

	private static void comb(int cnt, int start, int vcnt, int ncnt) {
		if (cnt == L) {
			if (vcnt < 1 || ncnt < 2) return;
			for (String c : select) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}
		for (int i = start; i < C; i++) {
			select[cnt] = alpha[i];
			if (isalpha(alpha[i]))
				comb(cnt + 1, i + 1, vcnt + 1, ncnt);
			else
				comb(cnt + 1, i + 1, vcnt, ncnt + 1);
		}
	}

	private static boolean isalpha(String c) {
		for (String v : vowl) {
			if (c.equals(v))
				return true;
		}
		return false;
	}
}
