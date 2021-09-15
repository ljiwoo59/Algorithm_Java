package silver;

import java.io.*;
import java.util.*;

// 백준 1463 1로 만들기 Silver 3

public class B1463 {
	static int num, result;
	static int[] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		d = new int[num + 1];
		
		d[1] = 0;
		for (int i = 2; i <= num; i++) {
			d[i] = d[i - 1] + 1;
			if (i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1);
			if (i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
			
		}
		
		System.out.println(d[num]);
		br.close();
	}

}