import java.io.*;

// SW 2805 농작물 수확하기 D3

public class SW2805_2 {
	static int N;
	static char[] arr;
	static int mid;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N];
			mid = N / 2;
			result = 0;
			for (int i = 0; i < N; i++) {
				arr = br.readLine().toCharArray();
				for (int n = Math.abs(mid - i); n < N - Math.abs(mid - i); n++)
					result += arr[n] - '0';
			}
			System.out.println("#" + t + " " + result);
		}
		br.close();
	}
}