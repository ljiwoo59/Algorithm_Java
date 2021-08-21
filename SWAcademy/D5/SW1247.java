import java.io.*;
import java.util.*;

// SW 1247 최적 경로 D 5

public class SW1247 {
	static int N, result;
	static int[] company, house;
	static Cust[] customer, select;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			company = new int[2];
			house = new int[2];
			customer = new Cust[N];
			select = new Cust[N];
			visit = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 2; i++) {
				company[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 2; i++) {
				house[i] = Integer.parseInt(st.nextToken());
			}
			int i = 0;
			while (st.hasMoreTokens()) {
				customer[i] = new Cust(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				i++;
			}
			
			perm(0);
			
			System.out.println("#" + t + " " + result);
		}
		br.close();
	}

	private static void perm(int cnt) {
		if (cnt == N) {
			int tmp = 0;
			int r = company[0];
			int c = company[1];
			for (int i = 0; i < N; i++) {
				tmp += Math.abs(r - select[i].r) + Math.abs(c - select[i].c);
				r = select[i].r;
				c = select[i].c;
			}
			tmp += Math.abs(house[0] - r) + Math.abs(house[1] - c);
			result = Math.min(result, tmp);
			
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			select[cnt] = customer[i];
			perm(cnt + 1);
			visit[i] = false;
		}
		
		
	}


}

class Cust {
	int r, c;
	
	Cust (int r, int c) {
		this.r = r;
		this.c = c;
	}
}
