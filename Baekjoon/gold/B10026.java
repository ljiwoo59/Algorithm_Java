import java.io.*;

// 백준 10026 적록색약 Gold 5

public class B10026 {
	static int N, normal, blind;
	static char[][] map;
	static int[][] visit;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (visit[r][c] == 0) {
					blind++;
					dfs_b(r, c, map[r][c]);
				}
				
				if (visit[r][c] == 1) {
					normal++;
					dfs_n(r, c, map[r][c]);
				}
			}
		}
		
		System.out.println(normal + " " + blind);
		br.close();
	}

	private static void dfs_b(int r, int c, char color) {
		visit[r][c] = 1;
		for (int i = 0; i < 4; i++) {
			int nxr = r + d[i][0];
			int nxc = c + d[i][1];
			
			if (nxr >= 0 && nxr < N && nxc >= 0 && nxc < N && visit[nxr][nxc] == 0) {
				if ((color == 'R' || color == 'G') && (map[nxr][nxc] == 'R' || map[nxr][nxc] == 'G'))
					dfs_b(nxr, nxc, color);
				else if (color == map[nxr][nxc])
					dfs_b(nxr, nxc, color);
			}
		}
		
	}

	private static void dfs_n(int r, int c, char color) {
		visit[r][c] = 2;
		for (int i = 0; i < 4; i++) {
			int nxr = r + d[i][0];
			int nxc = c + d[i][1];
			
			if (nxr >= 0 && nxr < N && nxc >= 0 && nxc < N && visit[nxr][nxc] == 1 && map[nxr][nxc] == color) {
				dfs_n(nxr, nxc, color);
			}
		}
		
	}

}
