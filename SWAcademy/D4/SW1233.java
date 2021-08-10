import java.io.*;
import java.util.*;

// SW 1233 사칙연산 유효성 검사 D 4

public class SW1233 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
		
			int result = 1;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				if (N % 2 == 0)
					result = 0;
				else {
					st.nextToken();
					int len = 0;
					String op = st.nextToken();
					while (st.hasMoreTokens()) {
						st.nextToken();
						len++;
					}
					
					if (len == 2 && !(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")))
						result = 0;
					else if (len == 0 && (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")))
						result = 0;
				}
			}
			sb.append("#" + t + " ");
			sb.append(result + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		br.close();
	}

}
