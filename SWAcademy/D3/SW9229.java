import java.io.*;
import java.util.*;

// SW 9229 한빈이와 Spot Mart D 3

public class SW9229 {
	static int[] snack;
	static boolean[] yes;
	static int N;
	static int M;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			snack = new int[N];
			yes = new boolean[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				snack[i] = Integer.parseInt(st.nextToken());
			
			result = -1;
			combination(0, 0, 0);
			System.out.println("#" + t + " " + result);
		}

	}

	private static void combination(int cnt, int start, int sum) {
		if (cnt == 2) {
			if (sum <= M && sum > result)
				result = sum;
			return ;
		}
		for (int i = start; i < N; i++)
			combination(cnt + 1, i + 1, sum + snack[i]);
	}

}
