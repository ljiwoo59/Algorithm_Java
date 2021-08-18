import java.io.*;
import java.util.*;

// 백준 3025 돌 던지기 Platinum 5

public class B3025 {
	static int R, C, N; // row, col, 횟수
	static char[][] map; // 맵 배열
	static int[][] d = {{0, -1}, {1, -1}, {0, 1}, {1, 1}}; // 왼쪽, 왼쪽아래, 오른쪽, 오른쪽아래
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C]; // 맵 초기화
		
		for (int i = 0; i < R; i++) { // 0 부터 row 까지 돌리며
			map[i] = br.readLine().toCharArray(); // 맵의 해당 row 의 정보를 char 배열로 받는다
		}
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) { // 하나의 화산탄이 떨어진 후 다음 화산탄이니까 순차적으로 열위치를 받아오며 진행
			int c = Integer.parseInt(br.readLine()) - 1; // 열 위치 (1 부터 들어오므로 1 을 빼줘서 맵열과 맞게 한다)
			vol(0, c); // 재귀 호출 시작
		}
		
		for (int i = 0; i < R; i++) { // 맵 row 당
			for (int j = 0; j < C; j++) { // 맵 col 당
				sb.append(map[i][j]); // 해당 위치의 맵 sb 에 추가
			}
			sb.append("\n"); // 한 row 가 끝나면 new line 처리
		}
		System.out.print(sb); // 출력
		br.close();
	}
	private static void vol(int r, int c) {
		if (r == R - 1 || map[r + 1][c] == 'X') { // 만약 해당 row 가 맨 밑이거나 다음 row 가 장애물이면
			map[r][c] = 'O'; // 그자리에 화산탄 놓고 종료
			return;
		}
		
		if (map[r + 1][c] == 'O') { // 만약 다음 row 가 화산탄이면
			int flag = 0; // 왼쪽, 왼쪽아래 혹은 오른쪽, 오른쪽 아래 둘다 만족하는지를 위한 플래그
			int nr = 0; // 새로운 row
			int nc = 0; // 새로운 col
			for (int i = 0; i < 2; i++) { // 왼쪽, 왼쪽아래 확인 먼저
				nr = r + d[i][0];
				nc = c + d[i][1];
				
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') { // 맵 안에있고 그 위치가 빈칸일때
					flag++; // 플래그 += 1
				}
			}
			if (flag == 2) // 만약 둘다 만족이면
				vol(nr, nc); // 새로운 row 와 col 로 재귀 시작
			else { // 왼쪽 조건을 만족하지 못했다면
				flag = 0; // 플래그는 0으로 초기화
				for (int i = 2; i < 4; i++) { // 오른쪽, 오른쪽 아래 확인
					nr = r + d[i][0]; // 새로운 row
					nc = c + d[i][1]; // 새로운 col
					
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') { // 맵 안에있고 그 위치가 빈칸일때
						flag++; // 플래그 += 1
					}
				}
				if (flag == 2) // 둘다 만족이면
					vol(nr, nc); // 새로운 row 와 col 로 재귀 시작
				else { // 만족하지 못하면 왼쪽 조건, 오른쪽조건 둘다 만족하지 않은 상태이므로
					map[r][c] = 'O'; // 현재 자리에 화산탄 놓기
					return; // 종료
				}
			}
		}
		else // 만약 빈칸이면
			vol(r + 1 , c);
	}

}
