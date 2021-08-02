package day1;

import java.io.*;
import java.util.*;

//백준 1244 스위치 켜고 끄기 Silver 4

public class B1244 {

	private static void turn(int[] arr, int i) {
		if (arr[i] == 1)
			arr[i] = 0;
		else
			arr[i] = 1;
	}
	
	private static void girl(int[] arr, int i, int side) {
		if ((i - side) < 0 || (i + side) >= arr.length || arr[i - side] != arr[i + side]) {
			return ;
		}
		turn(arr, i + side);
		turn(arr, i - side);
		girl(arr, i, side + 1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int[] Switch = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		while (st.hasMoreTokens())
			Switch[i++] = Integer.parseInt(st.nextToken());
		
		int num = Integer.parseInt(br.readLine());
		for (i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int no = Integer.parseInt(st.nextToken());
			if (sex == 1) {
				for (int j = no - 1; j < Switch.length; j++) {
					if ((j + 1) % no == 0)
						turn(Switch, j);
				}
			}
			else {
				turn(Switch, no - 1);
				if (no != 1)
					girl(Switch, no - 1, 1);
			}
		}
		
		for (int j = 0; j < Switch.length; j++) {
			System.out.print(Switch[j]);
			if (j != 0 && (j + 1) % 20 == 0)
				System.out.println();
			else
				System.out.print(" ");
		}
		br.close();
	}

}
