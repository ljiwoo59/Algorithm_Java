import java.io.*;
import java.util.*;

// 백준 2866 문자열 잘라내기 Gold 5 

public class B2866 {
	static int R, C;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		StringBuilder sb;
		Set<String> set;
		int cnt = 0;
		String[] arr = new String[C];
		
		for (int i = 0; i < C; i++) {
			sb = new StringBuilder();
			for (int j = 1; j < R; j++) {
				sb.append(map[j][i]);
			}
			arr[i] = sb + "";
		}
		
		
		end: for (int i = 0; i < R; i++) {
			set = new HashSet<>();
			for (int j = 0; j < C; j++) {
				String curr = arr[j].substring(i);
				if (set.contains(curr)) break end;
				else set.add(curr);
			}
			cnt++;
		}
		
		
		System.out.println(cnt);
	}
}
