package silver;

import java.util.Scanner;

// 백준 16953 Silver 1
public class B16953 { // 2를 곱한다 | 맨 오른쪽에 1을 붙인다
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int result = sc.nextInt();
		sc.close();
		int count = 0;
		
		while ((result != a) && (result / 2 != 0)) {
			if (result % 10 == 1) { // 맨 오른쪽 1 처리
				result /= 10;
				count++;
				continue;
			}
			if (result % 2 == 0) {
				result /= 2;
				count++;
			}
			else
				break;
		}
		if (a == result)
			System.out.println(count + 1);
		else
			System.out.println(-1);
	}
	
}
