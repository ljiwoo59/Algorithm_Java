import java.io.*;
import java.util.*;

// 백준 2493 탑  Gold 5

public class B2493 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Stack<int[]> h_i = new Stack<>();
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(st.nextToken());
			while (!h_i.isEmpty()) {
				if (h_i.peek()[0] > h) {
					sb.append(h_i.peek()[1] + " ");
					break;
				}
				h_i.pop();
			}
			if (h_i.isEmpty())
				sb.append(0 + " ");
			h_i.push(new int[] {h, i + 1});
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		br.close();
		/*
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[N];
		int max = arr[0], max_i = 0;
		for (int i = 1; i < N; i++) {
			if (arr[i] > arr[i - 1]) {
				if (max > arr[i]) {
					if (arr[i] < arr[result[i - 1] - 1])
						result[i] = result[i - 1];
					else
						result[i] = max_i + 1;
				}
				if (max < arr[i]) {
					max = arr[i];
					max_i = i;
				}
			}
			else {
				result[i] = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i : result) {
			sb.append(i);
			sb.append(" ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		br.close();
		*/
	}
}
