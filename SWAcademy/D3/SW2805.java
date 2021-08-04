import java.io.*;

// SW 2805 농작물 수확하기 D3

public class SW2805 {
	static int N;
	static char[][] arr;
	static int mid;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			for (int i = 0; i < N; i++)
				arr[i] = br.readLine().toCharArray();
			mid = N / 2;
			result = 0;
			sqaure(0);
			System.out.println("#" + t + " " + result);
		}
		br.close();
	}

	private static void sqaure(int row) {
		if (row == N - 1) {
			result += arr[row][mid] - '0';
			return ;
		}
		for (int n = Math.abs(mid - row); n < N - Math.abs(mid - row); n++)
			result += arr[row][n] - '0';
		sqaure(row + 1);
	}

}
