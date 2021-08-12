import java.io.*;
import java.util.*;

// 백준 2002 추월 Silver 1

public class B2002 {
	static int N;
	static LinkedList<String> in = new LinkedList<>();
	static LinkedList<String> out = new LinkedList<>();
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			in.offer(br.readLine());
		}
		for (int i = 0; i < N; i++) {
			out.offer(br.readLine());
		}
		
		while (!in.isEmpty()) {
			String i = in.peek();
			String o = out.poll();
			
			if (!i.equals(o)) {
				result++;
				in.remove(o);
			}
			else
				in.poll();
		}
		
		System.out.println(result);
	}

}
