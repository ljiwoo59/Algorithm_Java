package silver;

import java.io.*;
import java.util.*;

// 백준 9205 맥주 마시면서 걸어가기 Silver 1

public class B9205 {
	static class Coord {
		int x, y;
		
		Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int T, N;
	static Coord[] place;
	static int[][] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String result = "";
			N = Integer.parseInt(br.readLine());
			place = new Coord[N + 2];
			dist = new int[N + 2][N + 2];
			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				place[i] = new Coord(x, y);
			}
			
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					dist[i][j] = Math.abs(place[i].x - place[j].x) + Math.abs(place[i].y - place[j].y);
					dist[i][j] = Math.abs((int) Math.ceil(dist[i][j] / 50.0));
				}
			}
			
			if (dist[0][N + 1] <= 20) result = "happy";
			else {
				for (int k = 1; k < N + 1; k++) {
					for (int i = 0; i < N + 1; i++) {
						if (k == i) continue;
						for (int j = 1; j < N + 2; j++) {
							if (k == j || k == i) continue;
							if (dist[i][k] > 20 || dist[k][j] > 20) continue;
							if (dist[i][j] > dist[k][j]) dist[i][j] = dist[k][j];
						}
					}
				}
				if (dist[0][N + 1] <= 20) result = "happy";
				else result = "sad";
			}
			sb.append(result + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}
