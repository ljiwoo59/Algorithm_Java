import java.io.*;
import java.util.*;

// SW 1225 암호 생성기 D 3

public class SW1225 {
	static LinkedList<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 10; t++) {
			q.clear();
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			int i = 1;
			while (true) {
				if (i == 6)
					i = 1;
				if (q.peekLast() == 0)
					break;
				int put = q.poll() - i;
				if (put > 0)
					q.offer(put);
				else
					q.offer(0);
				i++;
			}
			
			StringBuilder sb = new StringBuilder();
			System.out.print("#" + T + " ");
			for (int j : q) {
				sb.append(j);
				sb.append(" ");
			}
			sb.setLength(sb.length() - 1);
			System.out.println(sb);
			sb.setLength(0);
		}
		br.close();

	}

}
