package gold;

import java.io.*;
import java.util.*;

// 백준 14719 빗물 Gold 5

public class B14719 {
	static int R, C, rMax, total;
	static int curr;
	static boolean[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			int r = Integer.parseInt(st.nextToken());
			if (r == 0) continue;
			rMax = Math.max(r, rMax);
			for (int j = 0; j < r; j++) {
				map[j][i] = true;
			}
		}

		for (int i = 0; i < rMax; i++) {
			curr = 0;
			while (curr < C) {
				if (map[i][curr] == false && (curr - 1 >= 0 && map[i][curr - 1] == true)) {
					water(i, 0);
				}
				curr++;
			}
		}
		
		System.out.println(total);
		br.close();
	}

	private static void water(int r, int cnt) {
		if (curr >= C) return;
		if (map[r][curr] == true) {
			total += cnt;
			return;
		}
		curr++;
		water(r, cnt + 1);
	}

}
