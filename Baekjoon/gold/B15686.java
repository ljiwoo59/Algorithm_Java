package gold;

import java.io.*;
import java.util.*;

// 백준 15686 치킨 배달 Gold 5

public class B15686 {
	static int N, M;
	static ArrayList<int[]> chick = new ArrayList<>(); // cr, cc
	static ArrayList<int[]> house = new ArrayList<>(); // hr, hc
	static ArrayList<int[]> select = new ArrayList<>(); // cr, cc
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2)
					chick.add(new int[] {i, j});
				else if (num == 1)
					house.add(new int[] {i, j});
			}
		}
		
		for (int i = 0; i < M; i++) {
			select.add(new int[2]);
		}
		comb(0, 0);

		System.out.println(result);
		br.close();
	}
	
	private static void comb(int cnt, int start) {
		if (cnt == M) {
			int tmp = 0;
			for (int[] h : house) {
				int min = Integer.MAX_VALUE;
				for (int [] s : select) {
					min = Math.min(min, Math.abs(s[0] - h[0]) + Math.abs(s[1] - h[1]));
				}
				tmp += min;
			}
			result = Math.min(result, tmp);
			return;
		}
		for (int i = start; i < chick.size(); i++) {
			select.set(cnt, chick.get(i));
			comb(cnt + 1, i + 1);
		}
		
	}

}
