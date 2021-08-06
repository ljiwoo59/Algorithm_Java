package gold;

import java.io.*;
import java.util.*;

// 백준 3190 뱀 Gold 5

public class B3190 {
	
	static LinkedList<int[]> snake = new LinkedList();
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //right down left up
	static int[][] map;
	static LinkedList<int[]> dir = new LinkedList();
	static int time = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 맵 크기
		int K = Integer.parseInt(br.readLine()); // 사과 갯수
		
		map = new int[N][N];
		map[0][0] = 1;
		snake.addFirst(new int[] {0,0});
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2; // 사과 위치 2
		}
		
		int L = Integer.parseInt(br.readLine()); // 방향 변환 횟수
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken()); // 초
			int lt = (st.nextToken().equals("D")) ? 1 : -1; // 오른쪽이면 시계방향, 왼쪽이면 반시계방향
			dir.addLast(new int[] {t, lt});
		}
		
		int d_i = 0;
		while (true) {
			time++;
			
			int nxr = snake.peekFirst()[0] + d[d_i][0];
			int nxc = snake.peekFirst()[1] + d[d_i][1];
			
			if (!(nxr >= 0 && nxr < N && nxc >= 0 && nxc < N)) { // 벽
				break;
			}
			else if (map[nxr][nxc] == 1) { // 몸
				break;
			}
	
			snake.addFirst(new int[] {nxr, nxc}); // move
			if (map[nxr][nxc] != 2) {
				map[snake.peekLast()[0]][snake.peekLast()[1]] = 0;
				snake.pollLast();
			}
			map[nxr][nxc] = 1;
			
			if (!dir.isEmpty() && dir.peekFirst()[0] == time) { // change dir
				d_i += dir.pollFirst()[1];
				if (d_i == 4)
					d_i = 0;
				else if (d_i == -1)
					d_i = 3;
			}
			
		}
		System.out.println(time);
		br.close();
	}

}
