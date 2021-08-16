package silver;

import java.io.*;
import java.util.*;

// 백준 1074 Z Silver 1

public class B1074 {
	static int N, R, C;
	static int start;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		divide(N, 0, 0);

		System.out.println(result);
		br.close();
	}

	private static void divide(int n, int r, int c) {
		if (n == 1) {
			if (r == R && c == C)
				result = start;
			else if (r == R && c < C)
				result = start + 1;
			else if (r < R && c == C)
				result = start + 2;
			else if (r < R && c < C)
				result = start + 3;
			return;
		}
		int mr = r + (int) (Math.pow(2, n) / 2);
		int mc = c + (int) (Math.pow(2, n) / 2);
		if (R < mr && C < mc) {
			start += 0;
		}
		else if (R < mr && C >= mc) {
			start += (int) (Math.pow(Math.pow(2, n - 1), 2));
			c = mc;
		}
		else if (R >= mr && C < mc) {
			start += (int) (Math.pow(Math.pow(2, n - 1), 2) * 2);
			r = mr;
		}
		else if (R >= mr && C >= mc) {
			start += (int) (Math.pow(Math.pow(2, n - 1), 2) * 3);
			r = mr;
			c = mc;
		}
		n--;
		divide(n, r, c);
	}

}
