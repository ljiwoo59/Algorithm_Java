package day5;

import java.io.*;

// 백준 9251 LCS Gold 5

public class B9251 {
	static int result;
	static int[][] LCS;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		LCS = new int[s1.length + 1][s2.length + 1];
		
		int result = 0;
		for (int i = 1; i <= s1.length; i++) {
			for (int j = 1; j <= s2.length; j++) {
				if (s1[i - 1] == s2[j - 1]) 
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				else
					LCS[i][j] = Math.max(LCS[i][j - 1], LCS[i - 1][j]);
				result = Math.max(LCS[i][j], result);
			}
		}
		System.out.println(result);
		br.close();
	}

}
