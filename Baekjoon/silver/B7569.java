import java.io.*;
import java.util.*;

// 백준 7569 토마토 Silver 1

public class B7569 {
	static int R, C, H;
	static int[][] tmt;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static LinkedList<int[]> queue = new LinkedList<>(); // r, c, boxl, days
	static int result = 0; // 토마토가 모두 익었을때로 초기화
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tmt = new int[R * H][C];
		
		for (int r = 0; r < R * H; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				tmt[r][c] = Integer.parseInt(st.nextToken());
				if (tmt[r][c] == 0) // 하나라도 안익은 토마토가 있을 경우 불가능으로 초기화
					result = -1;
			}
		}
		
		if (result == -1) {
			for (int r = 0; r < R * H; r++) {
				for (int c = 0; c < C; c++) {
					if (tmt[r][c] == 1)
						queue.offer(new int[] {r, c, r / R, 0});
				}
			}
			
			bfs();
		}
		
		for (int r = 0; r < R * H; r++) {
			for (int c = 0; c < C; c++) {
				if (tmt[r][c] == 0) {
					result = -1;
					break;
				}
			}
		}
		
		System.out.println(result);
		br.close();
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for (int i = 0; i < 4; i++) { // 2차원 상하좌우
				int nxr = curr[0] + d[i][0];
				int nxc = curr[1] + d[i][1];
				
				if (nxr >= curr[2] * R && nxr < (curr[2] + 1) * R && nxc >= 0 && nxc < C && tmt[nxr][nxc] == 0) {
					tmt[nxr][nxc] = 1;
					queue.offer(new int[] {nxr, nxc, curr[2], curr[3] + 1});
				}
			}
			int upr = curr[0] + R;
			int dwr = curr[0] - R;
			
			// 3차원 위 아래
			if (upr < R * H && tmt[upr][curr[1]] == 0) {
				tmt[upr][curr[1]] = 1;
				queue.offer(new int[] {upr, curr[1], curr[2] + 1, curr[3] + 1});
			}
			if (dwr >= 0 && tmt[dwr][curr[1]] == 0) {
				tmt[dwr][curr[1]] = 1;
				queue.offer(new int[] {dwr, curr[1], curr[2] - 1, curr[3] + 1});
			}
			
			result = Math.max(result, curr[3]);
		}
	
	}

}
