package gold;

import java.io.*;
import java.util.*;

// 백준 1089 스타트링크 타워 Gold 5

public class B1089 {
	static int N, C;
	static double res = 0, tot = 1;
	static char[][] map;
	static ArrayList<Integer>[] possN;
	static String[] numbers = {
							"###...#.###.###.#.#.###.###.###.###.###",
							"#.#...#...#...#.#.#.#...#.....#.#.#.#.#",
							"#.#...#.###.###.###.###.###...#.###.###",
							"#.#...#.#.....#...#...#.#.#...#.#.#...#",
							"###...#.###.###...#.###.###...#.###.###"};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		C = 4 * N - 1;
		map = new char[5][C];
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		possN = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			possN[i] = new ArrayList<>();
		}
		
		int flag = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				boolean isNum = checkNum(i, j);
				if (isNum) possN[i].add(j);
			}
			tot *= possN[i].size();
			if (tot == 0) {
				flag = 0;
				break;
			}
		}
		
		if (flag == 0) System.out.println(-1);
		else {
			for (int i = N - 1, hd = 1; i >= 0; i--, hd *= 10) {
				for (int j = 0; j < possN[i].size(); j++) {
					double poss = 1;
					for (int j2 = 0; j2 < N; j2++) {
						if (j2 == i) continue;
						poss *= possN[j2].size();
					}
					res += hd * poss * possN[i].get(j);
				}
			}
			res /= tot;
			System.out.println(res);
		}
		
		br.close();
	}

	private static boolean checkNum(int i, int j) {
		int startM = 4 * i;
		int startN = 4 * j;
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 3; c++) {
				if (map[r][c + startM] == '#' && numbers[r].charAt(c + startN) == '.') {
					return false;
				}
			}
		}
		return true;
	}
}
