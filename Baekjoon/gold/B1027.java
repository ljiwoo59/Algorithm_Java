package gold;

import java.io.*;
import java.util.*;

// 백준 1027 고층 건물 Gold 4

public class B1027 {
	static int N, tot, res;
	static double[] tower;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tower = new double[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tower[i] = Double.parseDouble(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int tot = 0;
			// left
			double slope = 0;
			if (i != 0) {
				slope = (tower[i - 1] - tower[i]) / -1.0;
				tot++;
				if (i == 11) System.out.println(slope);
				for (int j = i - 2; j >= 0; j--) {
					if ((tower[j] - tower[i]) / (j - i) < slope) {
						slope = (tower[j] - tower[i]) / (j - i);
						tot++;
					}
				}
				if (i == 11) System.out.println(slope);
			}
	
			//right
			if (i != N - 1) {
				slope = tower[i + 1] - tower[i];
				tot++;
				for (int j = i + 2; j < N; j++) {
					if ((tower[j] - tower[i]) / (j - i) > slope) {
						slope = (tower[j] - tower[i]) / (j - i);
						tot++;
					}
				}
			}
			
			res = Math.max(res, tot);
		}
		
		System.out.println(res);
	}

}
