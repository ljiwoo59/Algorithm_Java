package gold;

import java.io.*;

// 백준 6198 옥상 정원 꾸미기 Gold 5

public class B6198 {
	static long sum = 0;
	static int N;
	static int[] b;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		b = new int[N];
		for (int i = 0; i < N; i++) {
			b[i] = Integer.parseInt(br.readLine());
		}
		
		getsum(0);
		
		System.out.println(sum);
	}

	private static void getsum(int i) {
		if (i == N - 1)
			return ;
		for (int j = i + 1; j < N; j++) {
			if (b[j] >= b[i])
				break;
			sum++;
		}
		getsum(i + 1);
		
	}

}
