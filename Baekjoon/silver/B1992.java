import java.io.*;

// 백준 1992 쿼드트리 Silver 1

public class B1992 {
	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		char whole = check(0, 0, N, N);
		if (whole == '3') {
			divide(0, 0, N);
		}
		else
			sb.append(whole);
		
		System.out.println(sb);
		br.close();
	}

	private static void divide(int sr, int sc, int n) {
		char res;
		
		if (n == 2) {
			if ((res = check(sr, sc, sr + 2, sc + 2)) == '3') {
				sb.append("(");
				sb.append(map[sr][sc]);
				sb.append(map[sr][sc + 1]);
				sb.append(map[sr + 1][sc]);
				sb.append(map[sr + 1][sc + 1]);
				sb.append(")");
			}
			else
				sb.append(res);
			return;
		}
		
		sb.append("(");
		
		
		int mr = sr + n / 2;
		int mc = sc + n / 2;
		
		if ((res = check(sr, sc, mr, mc)) == '3') { // 1
			divide(sr, sc, n / 2);
		}
		else
			sb.append(res);
		if ((res = check(sr, mc, mr, N)) == '3') { // 2
			divide(sr, mc, n / 2);
		}
		else
			sb.append(res);
		if ((res = check(mr, sc, N, mc)) == '3') { // 3
			divide(mr, sc, n / 2);
		}
		else
			sb.append(res);
		if ((res = check(mr, mc, N, N)) == '3') { // 4
			divide(mr, mc, n / 2);
		}
		else
			sb.append(res);
		
		sb.append(")");
	}

	private static char check(int sr, int sc, int r, int c) {
		char init = map[sr][sc];
		for (int i = sr; i < r; i++) {
			for (int j = sc; j < c; j++) {
				if (map[i][j] != init)
					return '3';
			}
		}
		return init;
	}
}
