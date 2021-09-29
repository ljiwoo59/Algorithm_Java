import java.io.*;
import java.util.*;

// SW 5643 키 순서 D 4

public class SW5643 {
	
	static int T, V, E;
	static int[][] matrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			V = Integer.parseInt(br.readLine());
			E = Integer.parseInt(br.readLine());
			matrix = new int[V + 1][V + 1];
			for (int i = 0; i < E; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				matrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					for (int k = 1; k <= V; k++) {
						if (matrix[j][i] == 1 && matrix[i][k] == 1) matrix[j][k] = 1;
					}
				}
			}
			
			int result = 0;
			for (int i = 1; i <= V; i++) {
				int cnt = 0;
				for (int j = 1; j <= V; j++) {
					if (i == j) continue;
					if (matrix[i][j] == 0 && matrix[j][i] == 0) cnt++;
				}
				if (cnt == 0) result++;
			}
			
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}
