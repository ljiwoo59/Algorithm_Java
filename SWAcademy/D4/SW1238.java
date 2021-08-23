import java.io.*;
import java.util.*;

// SW 1238 Contact D 4

public class SW1238 {
	static int len, start, max, result;
	static int[][] r;
	static int[] visit;
	static LinkedList<int[]> queue = new LinkedList<>(); // node, level
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			r = new int[101][101];
			visit = new int[101];
			for (int i = 0; i < len / 2; i++) {
				r[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			queue.offer(new int[] {start, 0});
			visit[start] = 1;
			
			max = 0;
			result = 0;
			while (!queue.isEmpty()) {
				int[] curr = queue.poll();
				if (curr[1] > max) {
					max = curr[1];
					result = curr[0];
				}
				else if (curr[1] == max) {
					result = Math.max(result, curr[0]);
				}
				
				for (int i = 1; i <= 100; i++) {
					if (visit[i] == 0 && r[curr[0]][i] == 1) {
						visit[i] = 1;
						queue.offer(new int[] {i, curr[1] + 1});
					}
				}
			}
			
			sb.append("#" + t + " " + result + "\n");
			queue.clear();
		}
		System.out.print(sb);
		br.close();
	}

}
