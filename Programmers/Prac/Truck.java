import java.util.*;

// 프로그래머스 Stack/Queue > 다리를 지나는 트럭

public class Truck {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		
		int result = Solution(bridge_length, weight, truck_weights);
		
		System.out.println(result);
	}

	private static int Solution(int bridge_length, int weight, int[] truck_weights) {
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < truck_weights.length; i++) {
			queue.offer(truck_weights[i]);
		}
		
		int result = 0;
		int totW = 0;
		LinkedList<int[]> passing = new LinkedList<>(); // truck, time
		while (!queue.isEmpty()) {
			//System.out.println(pq.peek());
			result++;
			
			if (!passing.isEmpty() && passing.peekFirst()[1] == result - bridge_length) {
				int[] out = passing.poll();
				totW -= out[0];
			}
			
			if (passing.size() < bridge_length && totW + queue.peek() <= weight) {
				int now = queue.poll();
				passing.offer(new int[] {now, result});
				totW += now;
			}
		}
		
		while (!passing.isEmpty()) {
			result++;
			
			if (passing.peekFirst()[1] == result - bridge_length) passing.poll();
		}
		
		return result;
	}

}
