import java.io.*;
import java.util.*;

// SW 3307 최장 증가 부분 수열 D 3

public class SW3307 {
	static int T, N;
	static int[] nums, d;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			d = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				d[i] = 1;
				for (int j = 0; j < i; j++) {
					if (nums[j] < nums[i] && d[i] < d[j] + 1)
						d[i] = d[j] + 1;
				}
				if (max < d[i]) max = d[i];
			}
			sb.append("#" + t + " " + max + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}
