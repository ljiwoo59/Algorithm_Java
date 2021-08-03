import java.io.*;
import java.util.*;

// SW 1210 Ladder1 D4

public class SW1210 {
	static int[][] d = {{0, -1}, {0, 1}, {-1, 0}}; // left, right, up
	static int[][] arr = new int[100][100];
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int start_c = 0;
			for (int i = 0; i < 100; i++) { // set destination as start point
				if (arr[99][i] == 2)
					start_c = i;
			}
			
			findway(99, start_c);
			System.out.println("#" + t + " " + result);
		}
		br.close();
	}

	private static void findway(int start_r, int start_c) {
		if (start_r == 0)
			result = start_c;
		for (int j = 0; j < 3; j++) {
			int nr = start_r + d[j][0];
			int nc = start_c + d[j][1];
				
			if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100 && arr[nr][nc] == 1) {
				arr[start_r][start_c] = 0;
				findway(nr, nc);
				break;
			}
		}
		
	}

}
