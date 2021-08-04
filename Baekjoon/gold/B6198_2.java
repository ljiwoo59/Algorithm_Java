package gold;

import java.io.*;
import java.util.*;

// 백준 6198 옥상 정원 꾸미기 Gold 5
// stack 이용

public class B6198_2 {
	static long sum = 0;
	static int N;
	static int[] b;
	static Stack<Integer> s = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		b = new int[N];
		for (int i = 0; i < N; i++) {
			b[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < N; i++) {
			while (!s.isEmpty() && s.lastElement() <= b[i]) // 감소 순으로 놓기 위해 다음을 볼 수 없는 빌딩들은 빼준다
				s.pop();
			sum += s.size(); // 현재 선택된 위치 기준 보이는 빌딩 수 더해준다
			s.push(b[i]); // 다음 빌딩 넣어주기
		}
		
		System.out.println(sum);
	}

}
