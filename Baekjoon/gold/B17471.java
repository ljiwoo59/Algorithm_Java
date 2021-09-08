package gold;

import java.io.*;
import java.util.*;

//백준 17471 게리맨더링 Gold 5

public class B17471 {
	static int N, count, countA, countB, result = Integer.MAX_VALUE;
	static int[] ppl, visit, isSelected;
	static boolean[][] matrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ppl = new int[N + 1];
		visit = new int[N + 1];
		isSelected = new int[N + 1];
		matrix = new boolean[N + 1][N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			ppl[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int connect = Integer.parseInt(st.nextToken());
			for (int j = 0; j < connect; j++) {
				int connected = Integer.parseInt(st.nextToken());
				matrix[i][connected] = matrix[connected][i] = true;
			}
		}

		for (int i = 1; i <= N/2; i++) { // A 그룹에 포함될 구역 조합 정하기 (그룹이 상관 없기 때문에 N/2 개 까지 포함 시킨다)
			Arrays.fill(isSelected, 0);
			comb(i, 1, 0);
		}
		
		if (result == Integer.MAX_VALUE)
			result = -1;
		System.out.println(result);
	}

	private static void comb(int end, int start, int cnt) {
		if (cnt == end) {
			Arrays.fill(visit, 0);
			if (!check(cnt)) return;
			result = Math.min(result, Math.abs(countA - countB));
			return;
		}
		for (int i = start; i <= N; i++) {
			isSelected[i] = 1;
			comb(end, i + 1, cnt + 1);
			isSelected[i] = 0;
		}
		
	}

	private static boolean check(int cnt) { // 정한 구역이 인접한지 체크
		count = 1;
		for (int i = 1; i <= N; i++) {
			if (isSelected[i] == 1) { // check groupA
				countA = ppl[i]; // 인구 수
				dfs(i, 1);
				break;
			}
		}
		if (count != cnt) return false; // 정한 구역이 인접하지 않으면 false
		
		count = 1;
		for (int i = 1; i <= N; i++) { //check groupB
			if (isSelected[i] == 0) {
				countB = ppl[i]; // 인구 수
				dfs(i, 0);
				break;
			}
		}
		if (count != N - cnt) return false; // 정한 구역이 인접하지 않으면 false
		
		return true;
	}

	private static void dfs(int now, int flag) {
		visit[now] = 1;
		for (int i = 1; i <= N; i++) {
			if (matrix[now][i] && isSelected[i] == flag && visit[i] == 0) {
				count++;
				if (flag == 1) countA += ppl[i];
				else countB += ppl[i];
				dfs(i, flag);
			}
		}
	}

}
