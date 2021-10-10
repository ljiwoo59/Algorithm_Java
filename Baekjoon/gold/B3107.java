package gold;

import java.io.*;
import java.util.*;

// 백준 3107 IPv6 Gold 5

public class B3107 {
	static String[] ipv6 = new String[8];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) ipv6[i] = "";
		
		String[] tokens = br.readLine().split("::");
		
		if (tokens[0].length() != 0) {
			int idx = 0;
			StringTokenizer st = new StringTokenizer(tokens[0], ":");
			while (st.hasMoreTokens()) ipv6[idx++] = st.nextToken();
		}

		if (tokens.length == 2 && tokens[1].length() != 0) {
			int idx = 8;
			StringTokenizer st = new StringTokenizer(tokens[1], ":");
			idx -= st.countTokens();
			while (st.hasMoreTokens()) ipv6[idx++] = st.nextToken();
		}
		
		for (String s : ipv6) {
			int len = 4 - s.length();
			while (len-- != 0) sb.append("0");
			sb.append(s + ":");
		}
		sb.setLength(sb.length() - 1);
		
		System.out.println(sb);
		br.close();
		
	}

}
