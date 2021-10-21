package gold;

import java.io.*;
import java.util.*;

// 백준 3865 학회원 Gold 4

public class B3865 {
	static HashMap<String, HashSet<String>> type;
	static HashSet<String> visit, counted;
	static String start;
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 0;
		while ((t = Integer.parseInt(br.readLine())) != 0) {
			res = 0;
			type = new HashMap<>();
			for (int i = 0; i < t; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), ":.");
				String tmp = st.nextToken();
				if (i == 0) start = tmp;
				type.put(tmp, new HashSet<>());
				HashSet<String> curr = type.get(tmp);
				StringTokenizer st2 = new StringTokenizer(st.nextToken(), ",");
				while (st2.hasMoreTokens()) {
					curr.add(st2.nextToken());
				}
			}
			
			visit = new HashSet<>();
			counted = new HashSet<>();
			visit.add(start);
			
			for (String string : type.get(start)) {
				if (type.containsKey(string) && !visit.contains(string)) count(type.get(string));
				else if (!type.containsKey(string) && !counted.contains(string)) {
					counted.add(string);
					res++;
				}
			}
			
			sb.append(res + "\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static void count(HashSet<String> curr) {
		for (String string : curr) {
			if (type.containsKey(string) && !visit.contains(string)) {
				visit.add(string);
				count(type.get(string));
			}
			else if (!type.containsKey(string) && !type.get(start).contains(string) && !counted.contains(string)) {
				counted.add(string);
				res++;
			}
		}
		
	}

}
