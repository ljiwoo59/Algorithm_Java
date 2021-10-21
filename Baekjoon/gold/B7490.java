package gold;

import java.io.*;
import java.util.*;

// 백준 7490 0 만들기 Gold 5

public class B7490 {
	static int T, N;
	static String[] nums;
	static String[] res;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			res = new String[N];
			res[N - 1] = "";
			nums = new String[N];
			for (int i = 1; i <= N; i++) {
				nums[i-1] = Integer.toString(i);
			}
			
			rperm(0);
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
		br.close();
	}

	private static void rperm(int cnt) {
		if (cnt == N - 1) {
			String eq = "";
			for (int i = 0; i < N; i++) {
				eq += nums[i] + res[i];
			}
			String eq2 = eq.replaceAll(" ", "");
			StringTokenizer st = new StringTokenizer(eq2, "+-");
			int tot = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				if (res[i].equals(" ")) continue;
				else if (res[i].equals("+")) tot += Integer.parseInt(st.nextToken());
				else if (res[i].equals("-")) tot -= Integer.parseInt(st.nextToken());
			}
			if (tot == 0) sb.append(eq + "\n");
			return;
		}
		res[cnt] = " ";
		rperm(cnt + 1);
		res[cnt] = "+";
		rperm(cnt + 1);
		res[cnt] = "-";
		rperm(cnt + 1);
	}

}
