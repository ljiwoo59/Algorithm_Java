package gold;

import java.io.*;
import java.util.*;

// 백준 11401 이항 계수 3 Gold 1

public class B11401 {
	static int N, K, mod;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		mod = 1000000007;
		
		long top = factorial(N);
		long bottom = factorial(K) * factorial(N - K) % mod;
		
		System.out.println(top * power(bottom, mod - 2) % mod);
	}

	private static long power(long base, int exp) {
		long result = 1;
		
		while (exp > 0) {
			if (exp % 2 == 1) {
				result = (result * base) % mod;
			}
			base = (base * base) % mod;
			exp /= 2;
		}
		return result;
	}

	private static long factorial(int n) {
		long result = 1;
		
		while (n > 1) {
			result = (result * n--) % mod;
		}
		return result;
	}

}
