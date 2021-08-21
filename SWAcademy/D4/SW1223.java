import java.io.*;
import java.util.*;

// SW 1223 계산기2 D 4

public class SW1223 {
	static int N;
	static char[] input;
	static LinkedList<Character> stack, post;
	static LinkedList<Integer> calc;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			input = br.readLine().toCharArray();
			stack = new LinkedList<>();
			post = new LinkedList<>();
			calc = new LinkedList<>();
			
			// 후위 표기식으로 변환
			for (int i = 0; i < N; i++) {
				if (input[i] >= '0' && input[i] <= '9') // 숫자이면 바로 후위식에 넣어준다
					post.offer(input[i]);
				else if (stack.isEmpty()) // 연산자일시 스택이 비어있으면 바로 넣어준다
					stack.offer(input[i]);
				else { // 스택이 비어있지 않을 때는 현재 input[i] 와 지금까지의 스택 원소를 비교해야 한다
					while (!stack.isEmpty() && check(stack.peekLast()) >= check(input[i])) // 스택에 현재 연산자와 우선순위가 같거나 큰 연산자는 후위식에 넣는다
						post.offer(stack.pollLast());
					stack.offer(input[i]);
				}
			}
			while (!stack.isEmpty()) // 스택에 남아있는 연산자를 모두 후위식에 넣어준다
				post.offer(stack.pollLast());
			
			// 후위 표기식 계산
			while (!post.isEmpty()) {
				char c = post.poll();
				if (c >= '0' && c <= '9')
					calc.offer(c - '0');
				else if (c == '*') {
					calc.offer(calc.pollLast() * calc.pollLast());
				}
				else if (c == '+') {
					calc.offer(calc.pollLast() + calc.pollLast());
				}
			}
			
			sb.append("#" + t + " " + calc.peek() + "\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static int check(Character op) {
		if (op == '+')
			return 1;
		else if (op == '*')
			return 2;
		return 0;
	}

}
