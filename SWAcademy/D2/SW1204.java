package day1;

import java.io.*;
import java.util.*;

// SW 1204 최빈수 구하기 D2

public class SW1204 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int no = Integer.parseInt(br.readLine());
			int[] freq = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				freq[Integer.parseInt(st.nextToken())]++;
			}
			
			int max = 0;
			int index = 0;
			for (int j = 0; j < freq.length; j++) {
				if (freq[j] >= max) {
					max = freq[j];
					index = j;
				}
			}
			System.out.println("#" + no + " " + index);
		}
		br.close();
	}

}
