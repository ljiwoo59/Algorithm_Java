import java.io.*;
import java.util.*;

// 백준 2563 색종이 Silver 5

public class B2563 {
	static int[][] white = new int[100][100];
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int x_start = Integer.parseInt(st.nextToken());
			int y_start = Integer.parseInt(st.nextToken());
			
			for (int r = y_start; r < y_start + 10; r++) {
				for (int c = x_start; c < x_start + 10; c++) {
					if (white[r][c] == 0) {
						white[r][c] = 1;
						result++;
					}
				}
			}
		}
		System.out.println(result);
		br.close();
	}

}
