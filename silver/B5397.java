package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 백준 5397 키로거 Silver 3

public class B5397 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			String str = br.readLine();
			StringBuilder pw = new StringBuilder();
			Stack<Character> f = new Stack<>();
			Stack<Character> b = new Stack<>();
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '<' && !f.isEmpty()) {
					b.push(f.pop());
				}
				else if (str.charAt(i) == '>' && !b.isEmpty()) {
					f.push(b.pop());
				}
				else if (str.charAt(i) == '-' && !f.isEmpty()) {
					f.pop();
				}
				else if (str.charAt(i) != '<' && str.charAt(i) != '>' && str.charAt(i) != '-'){
					f.push(str.charAt(i));
				}
			}
			while (!b.isEmpty())
				f.push(b.pop());
			for (Character i : f) {
				pw.append(i);
			}
			System.out.println(pw);
		}
		br.close();
	}

}
