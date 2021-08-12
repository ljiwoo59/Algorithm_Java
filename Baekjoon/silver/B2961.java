import java.io.*;
import java.util.*;

// 백준 2961 도영이가 만든 맛있는 음식 Silver 1

public class B2961 {
	static int N;
	static long[][] food; // S, B
	static long min = Long.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		food = new long[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}

		subset(0, 0);
		
		System.out.println(min);
		br.close();
	}

	private static void subset(int index, int flag) {
		if (index == N) {
			int s = 1, b = 0;
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) != 0) {
					s *= food[i][0];
					b += food[i][1];
				}
			}
			if (s == 1 && b == 0) // 공집합
				return;
			min = Math.min(min, Math.abs(s - b));
			return;
		}
		subset(index + 1, flag | 1 << index);
		subset(index + 1, flag);
	}

}
