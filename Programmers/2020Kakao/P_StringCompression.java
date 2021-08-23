import java.io.*;

public class P_StringCompression {
	static String prev, curr;
	static int cnt, result;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int res = Solution(br.readLine());

		System.out.println(res);
		br.close();
	}

	private static int Solution(String s) {
		result = s.length();
		for (int i = 1; i < s.length(); i++) { // 볼 문자열 개수
			prev = s.substring(0, i);
			String tmp = "";
			cnt = 1;
			int index = i;
			for (int j = i; j + i < s.length(); j+= i) { // 문자열 순회
				curr = s.substring(j, j + i);
				
				if (curr.equals(prev)) cnt++; // 전 string 과 현 string 이 같으면 cnt++
				else { // 다르면
					if (cnt > 1) { // cnt 가 2 이상일 시 cnt 와 전 string 추가 및 cnt 초기화
						tmp += Integer.toString(cnt) + prev;
						cnt = 1;
					}
					else tmp += prev; // cnt 가 1 이면 전 string 추가
					prev = curr; // 전 string 을 현 string 으로 바꿈
				}
				index = j + i;
			}
			// 문자열 순회를 j + i 전까지만 보니까 마지막 처리
			curr = s.substring(index, s.length());
			if (curr.equals(prev)) tmp += Integer.toString(++cnt) + prev;
			else {
				if (cnt > 1) tmp += Integer.toString(cnt) + prev + curr;
				else tmp += prev + curr;
			}
		
			result = Math.min(result, tmp.length());
		}
		
		
		return result;
	}

}
