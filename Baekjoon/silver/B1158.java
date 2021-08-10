import java.io.*;
import java.util.*;

// 백준 1158 요세푸스 문제  Silver 5

public class B1158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		sb.append("<");
		
		LinkedList<Integer> person = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			person.add(i);
		}
		
		int index = 1;
		while (!person.isEmpty()) {
			if (index == K) {
				sb.append(person.poll() + ", ");
				index = 1;
			}
			else {
				person.offer(person.poll());
				index++;
			}
		}
		
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
		
		br.close();
	}

}
