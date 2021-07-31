package gold;

import java.io.*;
import java.util.*;

// 백준 4358 생태학 Gold 5

public class B4358 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> arr = new TreeMap<>();
		String str;
		double sum = 0;
		while ((str = br.readLine()) != null && str.length() != 0) {
			if (arr.containsKey(str))
				arr.put(str, arr.get(str) + 1);
			else
				arr.put(str, 1);
			sum++;
		}
		for (Map.Entry<String, Integer> e : arr.entrySet()) {
			System.out.printf("%s %.4f%n", e.getKey(), (e.getValue() / sum * 100));
		}
		br.close();
	}

}
