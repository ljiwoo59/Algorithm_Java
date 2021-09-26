package gold;

import java.io.*;
import java.util.*;

// 백준 2573 빙산 Gold 4

public class B2573 {
   static class Ice {
      int level, r, c;
      
      Ice(int level, int r, int c) {
         this.level = level;
         this.r = r;
         this.c = c;
      }
   }
   
   static int R, C, group, year;
   static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
   static int[][] map, visit;
   static LinkedList<Ice> ice = new LinkedList<>();
   static LinkedList<Ice> remove = new LinkedList<>();
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      map = new int[R][C];
      
      for (int i = 0; i < R; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < C; j++) {
            int tmp = Integer.parseInt(st.nextToken());
            map[i][j] = tmp;
            if (tmp != 0)
               ice.offer(new Ice(tmp, i, j));
         }
      }
      
      while (!ice.isEmpty()) {
         year += 1;
         
         ice: for (int i = ice.size() - 1; i >= 0; i--) { // 빙산 녹이기
            Ice curr = ice.get(i);
            for (int j = 0; j < 4; j++) {
               int nr = curr.r + d[j][0];
               int nc = curr.c + d[j][1];
               if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0)  {
                  curr.level -= 1;
                  if (curr.level <= 0) { // 다 녹으면 remove 배열에 추가하고 기본 빙산배열에서 제외
                     remove.offer(curr);
                     ice.remove(i);
                     continue ice;
                  }
               }
            }
            map[curr.r][curr.c] = curr.level;
         }
         
         while (!remove.isEmpty()) { // 다 녹은 빙산 업데이트
            Ice curr = remove.poll();
            map[curr.r][curr.c] = 0;
         }
         
         if (ice.isEmpty())
        	 break;
         
         // 빙산 개수 확인
         group = 1;
         visit = new int[R][C];
         Ice curr = ice.peek();
         dfs(curr.r, curr.c);
         if (group != ice.size())
            break;
      }
      
      if (!ice.isEmpty())
         System.out.println(year);
      else
         System.out.println(0);
      br.close();
   }

   private static void dfs(int r, int c) {
      visit[r][c] = 1;
      for (int i = 0; i < 4; i++) {
         int nr = r + d[i][0];
         int nc = c + d[i][1];
         if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 0 && visit[nr][nc] == 0) {
            dfs(nr, nc);
            group++;
         }
      }
   }

}