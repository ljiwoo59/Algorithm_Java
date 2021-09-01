package silver;

import java.io.*;
import java.util.*;

// 백준 1629 곱셈 Silver 1

public class B1629 {
	static int A, B, C;
	static long result = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		result = pow(A, B);
		
		System.out.println(result);
		br.close();
	}

	private static long pow(long b, long e) {
		if (e == 1) return b % C;
		long tmp = pow(b, e / 2);
		if (e % 2 == 0) return (tmp * tmp) % C;
		return ((tmp * tmp) % C * b) % C;
	}
}
