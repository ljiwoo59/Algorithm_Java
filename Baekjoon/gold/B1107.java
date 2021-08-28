package gold;

import java.io.*;
import java.util.*;

// 백준 1107 리모컨 Gold 5

public class B1107 {
	static int dest, start, result;
	static boolean[] broken;
	static String tmp = "";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dest = Integer.parseInt(br.readLine());
		start = 100;
		broken = new boolean[10];
		int brokenNum = Integer.parseInt(br.readLine());
		if (brokenNum != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		result = Math.abs(dest - start); // 단순 위아래 버튼만 눌렀을 때
		if (start != dest)
			perm(0, tmp);
		else
			result = 0;

		System.out.println(result);
		br.close();
	}

	private static void perm(int cnt, String temp) {
		if (temp != "") {
			int count = 0;
			count += temp.length();
			count += Math.abs(Integer.parseInt(temp) - dest);
			result = Math.min(result, count);
		}
		if (cnt > 7) return;
		for (int i = 0; i < 10; i++) {
			if (broken[i]) continue;
			perm(cnt + 1, temp + Integer.toString(i));
		}
		
	}

}
