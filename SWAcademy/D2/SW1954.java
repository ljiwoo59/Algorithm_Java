import java.io.*;

// SW 1954 달팽이 숫자 D2

public class SW1954 {
	static int N;
	static int[][] arr;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			snail(0, 0, 1, 0);
			
			System.out.println("#" + t);
			for (int[] row : arr) {
				for (int col : row) {
					sb.append(col);
					sb.append(" ");
				}
				sb.setLength(sb.length() - 1);
				sb.append("\n");
			}
			System.out.print(sb);
			sb.setLength(0);
		}
		br.close();
	}

	private static void snail(int row, int col, int num, int index) {
		if (index == 4)
			index = 0;
		if (num == (N * N)) {
			arr[row][col] = num;
			return ;
		}
		
		int nr = row + d[index][0];
		int nc = col + d[index][1];
		if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0) {
			arr[row][col] = num;
			snail(nr, nc, num + 1, index);
		}
		else
			snail(row, col, num, index + 1);
	}
}
