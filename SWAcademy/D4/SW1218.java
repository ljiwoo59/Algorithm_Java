import java.io.*;
import java.util.*;

// SW 1218 괄호 짝짓기 D 4

public class SW1218 {
	static char[] input;
	static int N;
	static Stack<Character> s;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			input = br.readLine().toCharArray();
			s = new Stack<>();
			
			for (int i = 0; i < N; i++) {
				if (s.isEmpty())
					s.push(input[i]);
				else {
					if (input[i] == ')' && s.peek() == '(')
						s.pop();
					else if (input[i] == ']' && s.peek() == '[')
						s.pop();
					else if (input[i] == '}' && s.peek() == '{')
						s.pop();
					else if (input[i] == '>' && s.peek() == '<')
						s.pop();
					else
						s.push(input[i]);
				}
			}
			int result = 1;
			if (!s.isEmpty())
				result = 0;
			System.out.println("#" + t + " " + result);
		}
		br.close();
	}

}
