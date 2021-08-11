import java.io.*;
import java.util.*;

// 백준 16926 배열 돌리기 1 Silver 3

public class B16926 {
	static int R, C, rot, dir;
	static int[][] arr;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
	static LinkedList<Integer> line;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		rot = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = Math.min(R, C) / 2;
		for (int t = 0; t < time; t++) {
			line = new LinkedList<>();
			line.offer(arr[t][t]);
			setline(t, t + 1, t, t);
			for (int i = 0; i < rot; i++) {
				line.offer(line.poll());
			}
			arr[t][t] = line.poll();
			setarr(t, t + 1, t, t);
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static void setarr(int r, int c, int ir, int ic) {
		if (r == ir && c == ic)
			return;
		if (dir == 4)
			dir = 0;
		
		int nxr = r + d[dir][0];
		int nxc = c + d[dir][1];
		if (nxr >= ir && nxr < R - ir && nxc >= ic && nxc < C - ic) {
			arr[r][c] = line.poll();
			setarr(nxr, nxc, ir, ic);
		}
		else {
			dir += 1;
			setarr(r, c, ir, ic);
		}
		
	}

	private static void setline(int r, int c, int ir, int ic) {
		if (r == ir && c == ic)
			return;
		if (dir == 4)
			dir = 0;
		
		int nxr = r + d[dir][0];
		int nxc = c + d[dir][1];
		if (nxr >= ir && nxr < R - ir && nxc >= ic && nxc < C - ic) {
			line.offer(arr[r][c]);
			setline(nxr, nxc, ir, ic);
		}
		else {
			dir += 1;
			setline(r, c, ir, ic);
		}
		
	}

}
