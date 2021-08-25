import java.io.*;
import java.util.*;

// 16234 인구 이동 Gold 5

public class B16234 {
	static int N, L, R;
	static int flag, union, tot, cnt, result;
	static int[][] map, visit;
	static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static LinkedList<int[]> select;
	static LinkedList<Integer> people;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		flag = 1;
		while (flag == 1) {
			select = new LinkedList<>();
			people = new LinkedList<>();
			visit = new int[N][N];
			union = 1;
			flag = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] == 0) {
						tot = 0;
						cnt = 1;
						find(i, j);
						union++;
						if (cnt == 1) select.pollLast();
						else people.offer(tot / cnt);
					}
				}
			}
			
			if (flag == 0) break;
			
			while (!select.isEmpty()) {
				int[] curr = select.poll();
				
				map[curr[0]][curr[1]] = people.peekFirst();
				
				if (!select.isEmpty() && curr[2] != select.peekFirst()[2]) people.poll();
			}
			
			result++;
		}
		
		System.out.println(result);
		br.close();
	}

	private static void find(int r, int c) {
		visit[r][c] = union;
		tot += map[r][c];
		select.offer(new int[] {r, c, union});
		
		for (int i = 0; i < 4; i++) {
			int nr = r + d[i][0];
			int nc = c + d[i][1];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && visit[nr][nc] == 0 && 
					((Math.abs(map[nr][nc] - map[r][c])) >= L && (Math.abs(map[nr][nc] - map[r][c])) <= R)) {
				cnt +=1;
				flag = 1;
				find(nr, nc);
			}
		}
		
	}

	

}
