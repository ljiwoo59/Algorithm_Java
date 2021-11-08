package gold;

import java.io.*;
import java.util.*;

// 백준 9207 페그 솔리테어 Gold 5

public class B9207 {
	static int T, R = 5, C = 9;
	static int minPin, minMove;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			char[][] map = new char[R][C];
			int pin = 0;
			for (int i = 0; i < R; i++) {
				String tmpS = br.readLine();
				for (int j = 0; j < C; j++) {
					char tmpC = tmpS.charAt(j);
					if (tmpC == 'o') pin++;
					map[i][j] = tmpC;
				}
			}
			
			minPin = 8;
			minMove = Integer.MAX_VALUE;
			game(map, pin, 0);
			if (minPin == 8 && minMove == Integer.MAX_VALUE) minMove = 0;
			sb.append(minPin + " " + minMove + "\n");
			
			if (t < T - 1) br.readLine();
		}
		System.out.print(sb);
		br.close();
	}

	private static void game(char[][] map, int pin, int move) {
		if (pin < minPin) {
			minPin = pin;
			minMove = move;
		}
		else if (pin == minPin) {
			minMove = Math.min(move, minMove);
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'o') {
					for (int k = 0; k < 4; k++) {
						int nr = i + d[k][0];
						int nc = j + d[k][1];
						int nnr = nr + d[k][0];
						int nnc = nc + d[k][1];
						if (nr >= 0 && nr < R && nc >= 0 && nc < C &&
								nnr >= 0 && nnr < R && nnc >= 0 && nnc < C &&
								map[nr][nc] == 'o' && map[nnr][nnc] == '.') {
							map[i][j] = map[nr][nc] = '.';
							map[nnr][nnc] = 'o';
							game(map, pin - 1, move + 1);
							map[i][j] = map[nr][nc] = 'o';
							map[nnr][nnc] = '.';
						}
					}
				}
			}
			
		}
		
	}

}
