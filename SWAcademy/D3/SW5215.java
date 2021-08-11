import java.io.*;
import java.util.*;

// SW 5215 햄버거 다이어트 D 3

public class SW5215 {
	static int N, L, result;
	static int[][] arr; // taste, kcal
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			isSelected = new boolean[N];
			arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
		
			result = 0;
			sub(0);
			System.out.println("#" + t + " " + result);
		}
		br.close();
	}

	private static void sub(int index) {
		if (index == N) {
			int taste = 0, kcal = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					taste += arr[i][0];
					kcal += arr[i][1];
				}
			}
			if (kcal <= L)
				result = Math.max(result, taste);
			return;
		}
		isSelected[index] = true;
		sub(index + 1);
		isSelected[index] = false;
		sub(index + 1);
	}

}
