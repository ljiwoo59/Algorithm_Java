import java.io.*;
import java.util.*;

// SW 1873 상호의 배틀필드 D 3

public class SW1873 {
	static int row, col, cmd;
	static char[][] arr;
	static char[] cmd_l;
	static int pr = -1, pc = -1, dir = -1;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up down left right
	static char[] printcar = {'^', 'v', '<', '>'};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			arr = new char[row][col];
			dir = -1;
			for (int r = 0; r < row; r++) {
				arr[r] = br.readLine().toCharArray();
				if (dir == -1) { // find car pos and dir
					for (int c = 0; c < col; c++) {
						if (arr[r][c] == '^') {
							pr = r;
							pc = c;
							dir = 0;
						}
						else if (arr[r][c] == 'v') {
							pr = r;
							pc = c;
							dir = 1;
						}
						else if (arr[r][c] == '<') {
							pr = r;
							pc = c;
							dir = 2;
						}
						else if (arr[r][c] == '>') {
							pr = r;
							pc = c;
							dir = 3;
						}
					}
				}
			}
			
			cmd = Integer.parseInt(br.readLine());
			cmd_l = br.readLine().toCharArray();
			
			for (char c : cmd_l) {
				if (c == 'S')
					shoot(pr + d[dir][0], pc + d[dir][1]);
				else
					move(c);
			}
			System.out.print("#" + t + " ");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < row; i++) {
				sb.append(arr[i]);
				sb.append("\n");
			}
			sb.setLength(sb.length() - 1);
			System.out.println(sb);
			sb.setLength(0);
		}
		br.close();
	}

	private static void shoot(int r, int c) {
		if (r < 0 || r >= row || c < 0 || c >= col || arr[r][c] == '#') {
			return;
		}
		if (arr[r][c] == '*') {
			arr[r][c] = '.';
			return ;
		}
		shoot(r + d[dir][0], c + d[dir][1]);
	}

	private static void move(char c) {
		if (c == 'U')
			dir = 0;
		else if (c == 'D')
			dir = 1;
		else if (c == 'L')
			dir = 2;
		else
			dir = 3;
		
		arr[pr][pc] = printcar[dir];
		int nr = pr + d[dir][0];
		int nc = pc + d[dir][1];
		if (nr >= 0 && nr < row && nc >= 0 && nc < col && arr[nr][nc] == '.') {
			arr[pr][pc] = '.';
			pr = nr;
			pc = nc;
			arr[pr][pc] = printcar[dir];
		}
		
		
	}

}
