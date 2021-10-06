import java.util.*;

// 프로그래머스 Hash > 위장

public class Camouflage {

	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

		int result = Solution(clothes);
		
		System.out.println(result);
	}

	private static int Solution(String[][] clothes) {
		HashMap<String, Integer> C = new HashMap<>();
		for (String[] strings : clothes) {
			if (C.containsKey(strings[1])) C.put(strings[1], C.get(strings[1]) + 1);
			else C.put(strings[1], 1);
		}
		
		int res = 1;
		for (Map.Entry<String, Integer> e : C.entrySet()) {
			res *= e.getValue() + 1;
		}
		return res - 1;
	}

}
