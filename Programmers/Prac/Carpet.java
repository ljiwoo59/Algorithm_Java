import java.util.*;

// 프로그래머스 완전탐색 > 카펫

public class Carpet {

	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		
		int[] result = Solution(brown, yellow);
		
		System.out.println(Arrays.toString(result));
	}

	private static int[] Solution(int brown, int yellow) {
		int area = brown + yellow;
		
		int[] res = new int[2];
		for (int i = area / 2; i >= 3; i--) {
			if (area % i == 0) {
				int width = i;
				int height = area / i;
				if (width >= height && (width - 2) * (height - 2) == yellow) {
					res[0] = width;
					res[1] = height;
					break;
				}
			}
		}
		
		return res;
	}

}
