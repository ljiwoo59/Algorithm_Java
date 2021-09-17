package silver;

import java.io.*;

// 백준 11057 오르막 수 Silver 1

public class B11057 {
	static int N;
	static int d[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		d = new int[N + 1][10];
		
		for (int i = 0; i < 10; i++) {
			d[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) { // 수의 길이
			for (int j = 0; j < 10; j++) { // 올 수 있는 수 (d[i][j] 는 해당 자리수에 올 수 있는 수의 개수)
				for (int k = 0; k <= j; k++) {
					d[i][j] = (d[i][j] + d[i - 1][k]) % 10007; // 해당 자리 수 + 이전 자리수의 모든 경우
				}
			}
		}
		
		int res = 0;
		for (int i = 0; i < 10; i++) {
			res = (res + d[N][i]) % 10007;
		}
		
		System.out.println(res);
		br.close();
	}

}
