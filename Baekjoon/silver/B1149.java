package silver;

import java.io.*;
import java.util.*;

// 백준 1149 RGB 거리 Silver 1

public class B1149 {
	static int num;
	static int[][] house, d; // r, g, b
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		house = new int[num + 1][3];
		d = new int[num + 1][3];
		for (int i = 1; i <= num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= num; i++) {
			d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + house[i][0];
			d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + house[i][1];
			d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + house[i][2];
		}
		
		int result = Math.min(d[num][0], Math.min(d[num][1], d[num][2]));
		
		System.out.println(result);
		br.close();
	}

}
