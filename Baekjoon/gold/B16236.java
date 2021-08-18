import java.io.*;
import java.util.*;

// 백준 16236 아기 상어 Gold 4

public class B16236 {
   static int N, init, time, cnt;
   static int[] pos; // row, col
   static int[][] map, visit;
   static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
   static LinkedList<Fish> queue = new LinkedList<>(); // row, col, level(dist)
   static LinkedList<Fish> select = new LinkedList<>();  // row, col, level(dist)
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      map = new int[N][N];
      visit = new int[N][N];
      for (int i = 0; i < N; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         for (int j = 0; j < N; j++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 9) {
               pos = new int[] {i, j};
               n = 0;
            }
            map[i][j] = n;
         }
      }
      
      init = 2;
      queue.offer(new Fish(pos[0], pos[1], 0));
      visit[pos[0]][pos[1]] = 1;
      while (close() != -1) { // 현 pos 에서 가장 가깝고 현 크기보다 작은 물고기들 찾기 -> select
    	  Collections.sort(select); // 주어진 기준으로 정렬 (head 에 있는 아이 선택)
    	  Fish remove = select.poll();
    	  cnt += 1;
    	  time += remove.lev;
    	  pos[0] = remove.r;
    	  pos[1] = remove.c;
    	  map[remove.r][remove.c] = 0;
    	  if (cnt == init) {
    		  init += 1;
    		  cnt = 0;
    	  }
    	  queue.clear();
    	  select.clear();
    	  visit = new int[N][N];
    	  queue.offer(new Fish(pos[0], pos[1], 0));
    	  visit[pos[0]][pos[1]] = 1;
      }
      
      System.out.println(time);
      br.close();
   }

   private static int close() {
	   while (!queue.isEmpty()) {
		   Fish curr = queue.poll();
		   if (map[curr.r][curr.c] > 0 && map[curr.r][curr.c] < init) {
			   if (select.isEmpty() || select.peek().lev == curr.lev) // 비어있거나 현재 칸 수와 고른 칸 수가 같으면 추가
				   select.offer(curr);
			   else if (select.peek().lev > curr.lev) { // 현재 고른 칸수 보다 고른 칸 수가 크면 현재 고른 칸수로 새로운 리스트
				   select.clear();
				   select.offer(curr);
			   }
			   else if (select.peek().lev < curr.lev) // 고른 칸수 보다 현재 고른 칸수가 크면 종료
				   return 1;
		   }
		   
		   for (int i = 0; i < 4; i++) {
			   int nr = curr.r + d[i][0];
			   int nc = curr.c + d[i][1];
			   if (nr >= 0 && nr < N && nc >= 0 && nc < N && visit[nr][nc] == 0 && map[nr][nc] <= init) { // 나보다 작거나 같은 곳만 갈 수 있음
				   visit[nr][nc] = 1;
				   queue.offer(new Fish(nr, nc, curr.lev + 1));
			   }
		   }
	   }
	   
	   if (!select.isEmpty())
		   return 1;
	   return -1;
   }
 
}

class Fish implements Comparable<Fish>{
	int r, c, lev;
	
	Fish(int r, int c, int lev) {
		this.r = r;
		this.c = c;
		this.lev = lev;
	}

	@Override
	public int compareTo(Fish o) {
		if (this.r - o.r == 0) // 가장 위에 있는 물고기가 여러마리라면
			return this.c - o.c; // 가장 왼쪽에 있는 물고기
		return this.r - o.r; // 가장 위에 물고기 반환
	}
}
