import java.io.*;
import java.util.*;

// SW 1208 Flatten D 3

public class SW1208 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int count = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			List<Integer> box = new ArrayList<>();
			for (int h = 0; h < 100; h++) {
				box.add(Integer.parseInt(st.nextToken()));
			}
			
			while (count != 0) {
				int min = Collections.min(box);
				int max = Collections.max(box);
				
				if (max - min <= 1)
					break;
				
				box.set(box.indexOf(min), min + 1);
				box.set(box.indexOf(max), max - 1);
				count--;
			}
			System.out.println("#" + (i + 1) + " " + (Collections.max(box) - Collections.min(box)));
		}
		br.close();
	}

}
