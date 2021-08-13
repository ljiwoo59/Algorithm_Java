import java.io.*;
import java.util.*;

// 백준 1937 욕심쟁이 판다 Gold 3

public class B1937 {
	static int N;
	static int[][] map, visit;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int max, result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				dfs(r, c);
				result = Math.max(visit[r][c], result);
			}
		}
		System.out.println(result + 1);
		br.close();
	}

	private static void dfs(int r, int c) {
		if (visit[r][c] != 0)
			return;
		for (int i = 0; i < 4; i++) {
			int nxr = r + d[i][0];
			int nxc = c + d[i][1];
			if (nxr >= 0 && nxr < N && nxc >= 0 && nxc < N && map[nxr][nxc] > map[r][c]) {
				if (visit[nxr][nxc] == 0)
					dfs(nxr, nxc);
				visit[r][c] = Math.max(visit[nxr][nxc] + 1, visit[r][c]);
			}
		}
	}

}
