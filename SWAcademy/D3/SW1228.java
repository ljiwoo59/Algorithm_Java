package day4;

import java.io.*;
import java.util.*;

// SW 1228 암호문 1 D 3

public class SW1228 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			ArrayList<String> code = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				code.add(st.nextToken());
			}
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "I");
			for (int i = 0; i < n; i++) {
				StringTokenizer st2 = new StringTokenizer(st.nextToken(), " ");
				int index = Integer.parseInt(st2.nextToken());
				int num = Integer.parseInt(st2.nextToken());
				for (int j = 0; j < num; j++) {
					code.add(index + j, st2.nextToken());
				}
			}
			
			int count = 0;
			sb.append("#");
			sb.append(t);
			sb.append(" ");
			for (String string : code) {
				if (count == 10)
					break;
				sb.append(string);
				sb.append(" ");
				count++;
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
