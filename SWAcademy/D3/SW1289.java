import java.io.*;

// SW 1289 원재의 메모리 복구하기 D3

public class SW1289 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int no = Integer.parseInt(br.readLine());
		for (int i = 0; i < no; i++) {
			char[] arr = br.readLine().toCharArray();
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '1') {
					arr[j] = '0';
					count++;
					for (int k = j + 1; k < arr.length; k++) {
						if (arr[k] == '1')
							arr[k] = '0';
						else
							arr[k] = '1';
					}
				}
			}
			
			/**
			 * 다른 방법
			 * 
			 * String s = br.readLine();
			 * int cnt = 0;
			 * 
			 * if (s.startsWith("1")) {
			 * 		cnt++;
			 * }
			 * for (int j = 0; j < s.length() - 1; j++) {
			 * 		if (s.charAt(j) != s.charAt(j + 1)) {
			 * 			cnt++;
			 * 		}
			 * }
			 * 
			 */
			
			
			System.out.println("#" + (i + 1) + " " + count);
		}
		br.close();
	}
}
