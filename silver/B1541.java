package silver;

import java.util.Scanner;

// 백준 1541 잃어버린 괄호 Silver 2

public class B1541 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String eq = sc.nextLine();
		sc.close();
		String[] splitted = eq.split("((?=[-+]))");
		int[] nums = new int[splitted.length];
		int index = 0;
		for (String i : splitted) 
			nums[index++] = Integer.parseInt(i);
		
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i <nums.length - 1 && nums[i] < 0) {
				if (nums[i] - Math.abs(nums[i + 1]) > nums[i] + nums[i - 1]) {
					nums[i - 1] = nums[i] - nums[i - 1];
					nums[i] = 0;
				}
				else {
					nums[i + 1] = nums[i] - Math.abs(nums[i + 1]);
					nums[i] = 0;
				}
			}
		}
		for (int i : nums)
			result += i;
		System.out.println(result);
	}

}
