package day8;

import java.io.*;

// 백준 9663 N-Queen Gold5

public class B9663 {
	static int N, result;
	static int col[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N + 1];
		
		setQueens(1); // 1행 부터 놓는 시도
		System.out.println(result);
		br.close();
	}

	private static void setQueens(int row) {
		if (row > N) { // 마지막 행
			result++;
			return;
		}

		// 현재 퀸 1열 부터 N 열까지 놓아보기
		// 놓았으면 다음 퀸 놓으러 가기
		for (int i = 1; i <= N; i++) {
			col[row] = i; // i 열에 놓아보기
			if (isAvailable(row)) // row - 1 행까지 유망한지 체크
				setQueens(row + 1);
		}
	}

	private static boolean isAvailable(int row) { // row : 현재 검사하려는 퀸
		for (int k = 1; k < row; k++) { // k: 이전 퀸
			if (col[row] == col[k] || Math.abs(col[row] - col[k]) == (row - k)) return false;
		}
		return true;
	}

}
