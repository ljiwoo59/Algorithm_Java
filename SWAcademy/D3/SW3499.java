// SW 3499 퍼펙트 셔플 D 3

import java.io.*;
import java.util.*;

public class SW3499 {
	static Queue<String> card1;
	static Queue<String> card2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int t = 1; t <= N; t++) {
			card1 = new LinkedList<>();
			card2 = new LinkedList<>();
			double size = Integer.parseInt(br.readLine());
			String[] st = br.readLine().split(" ");	
			for (int i = 0; i < Math.ceil(size / 2); i++) {
				card1.offer(st[i]);
			}
			for (int i = (int) Math.ceil(size / 2); i < size; i++) {
				card2.offer(st[i]);
			}	
			sb.append("#" + t + " ");
			for (int i = 0; i < size; i++) {
				if (i % 2 == 0)
					sb.append(card1.poll() + " ");
				else
					sb.append(card2.poll() + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");	
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
