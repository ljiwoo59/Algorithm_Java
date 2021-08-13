import java.io.*;
import java.util.*;

// 백준 17135 캐슬 디펜스 Gold 4

public class B17135 {
	static int R, C, D;
	static LinkedList<Enemy> enemy = new LinkedList<>();
	static LinkedList<Enemy> copy = new LinkedList<>();
	static int[] archer = new int[3]; // c... r is always R
	static Enemy[] remove = new Enemy[3];
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1)
					enemy.offer(new Enemy(i, j));
			}
		}
		
		comb(0, 0);
		
		System.out.println(result);
		br.close();
	}

	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			for (int i = 0; i < enemy.size(); i++) {
				copy.offer(new Enemy(enemy.get(i).r, enemy.get(i).c));
			}
			int each = game();
			result = Math.max(result, each);
			return;
		}
		for (int i = start; i < C; i++) {
			archer[cnt] = i;
			comb(cnt + 1, i + 1);
		}
		
	}

	private static int game() {
		int tot = 0;
		while (!copy.isEmpty()) {
			// archer turn
			for (int i = 0; i < 3; i++) {
				int min = Integer.MAX_VALUE;
				Enemy select = null;
				for (Enemy e : copy) {
					int dist = Math.abs(R - e.r) + Math.abs(archer[i] - e.c);
					if (dist <= D && min >= dist) {
						if (min == dist && (e.c < select.c)) {
							select = e;
						}
						else if (min > dist) {
							min = dist;
							select = e;
						}
					}
				}
				remove[i] = select;
			}
			for (int i = 2; i >= 0; i--) {
				if (copy.remove(remove[i])) tot++;
			}
			// enemy turn	
			for (int i = copy.size() - 1; i >= 0; i--) {
				Enemy e = copy.get(i);
				e.move();
				if (e.r == R)
					copy.remove(e);
			}
		}
		return tot;
	}

}

class Enemy {
	int r;
	int c;
	
	public Enemy(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	public void move() {
		this.r += 1;
	}
}
