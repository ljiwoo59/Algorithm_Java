package gold;

import java.util.Scanner;

// 백준 14052 연구소 Gold 5

public class B14502 {
	static int row;
	static int col;
	static int[][] arr;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int clean = 0;
	
	public static void count(int[][] tmp) {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (tmp[r][c] == 2) {
					for (int i = 0; i < 4; i++) {
						int nxr = r + d[i][0];
						int nxc = c + d[i][1];
						
						if (nxr >= 0 && nxr < row && nxc >= 0 && nxc < col && tmp[nxr][nxc] == 0) {
							tmp[nxr][nxc] = 2;
							count(tmp);
						}
					}
				}
			}
		}
		int count = 0;
		for (int[] r : tmp) {
			for (int c : r) {
				if (c == 0)
					count++;
			}
		}
		if (count > clean)
			clean = count;
	}
	
	public static void dfs(int[][] arr, int cr, int cc, int wall) {
		if (wall == 3) {
			int[][] tmp = new int[row][col];
			for (int r = 0; r < row; r++) {
				System.arraycopy(arr[r], 0, tmp[r], 0, col);
			}
			count(tmp);
			return ;
		}
		
		for (int r = cr; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (arr[r][c] == 0) {
					arr[r][c] = 1;
					dfs(arr, r, c, wall + 1);
					arr[r][c] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		sc.nextLine();
		arr = new int[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		dfs(arr, 0, 0, 0);
		System.out.println(clean);
		sc.close();

	}
	
}
