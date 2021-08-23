import java.io.*;

public class P_NewID {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String result = Solution(br.readLine());
		
		System.out.println(result);
		br.close();

	}

	private static String Solution(String new_id) {
		new_id = new_id.toLowerCase(); // 1
		
		String pattern = "[^a-z0-9\\-_\\.]"; // 2  알파벳이나 숫자가 아니거나 _ . - 가 아니면 ( [] 은 문자집합, 집합 안에 ^ 가 있으면 not) 특수문자 앞엔 \\ 로 일반문자로 표시
		new_id = new_id.replaceAll(pattern, "");

		pattern = "\\.{2,}"; // 3 2개 이상 . 이면
		new_id = new_id.replaceAll(pattern, ".");

		pattern = "^\\.|\\.$"; // 4 문자열 처음이나 끝에 . 이면 (^ 은 시작, $ 은 끝)
		new_id = new_id.replaceAll(pattern, "");

		if (new_id.length() == 0) // 5
			new_id = "a";
		
		if (new_id.length() > 15) // 6
			new_id = new_id.substring(0, 15);
		pattern = "\\.$";
		new_id = new_id.replaceAll(pattern, "");
		
		if (new_id.length() < 3) { // 7
			while (new_id.length() != 3) {
				new_id += new_id.substring(new_id.length() - 1);
			}
		}
		
		return new_id;
	}

}
