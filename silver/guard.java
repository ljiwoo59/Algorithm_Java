package silver;

import java.util.Arrays;
import java.util.Scanner;

// 백준 2564 경비원 Silver1

public class guard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int count = sc.nextInt();
		int[][] s_arr = new int[count + 1][2]; // location of stores and a guard: width, height
		for (int i = 0; i < count; i++) { // 1: N, 2: S, 3: W, 4: E
			s_arr[i][0] = sc.nextInt();
			s_arr[i][1] = sc.nextInt();
		}
		s_arr[count][0] = sc.nextInt();
		s_arr[count][1] = sc.nextInt();

		int min = 0;		
		for (int i = 0; i < count; i++) {
			int clockwise = 0;
			int counterclock = 0;
			
			int[] tmp_c = Arrays.copyOf(s_arr[count], 2); // tmp direction of guard
			int[] tmp_cc = Arrays.copyOf(s_arr[count], 2); 
			while (tmp_c[0] != s_arr[i][0]) { // clockwise check
				if (tmp_c[0] == 2 || tmp_c[0] == 3) { // S or W
					clockwise += tmp_c[1];
					tmp_c[0] = (tmp_c[0] == 2) ? 3 : 1;
					tmp_c[1] = (tmp_c[0] == 3) ? h : 0;
				}
				else { // N or E
					clockwise += (tmp_c[0] == 1) ? w - tmp_c[1] : h - tmp_c[1];
					tmp_c[0] = (tmp_c[0] == 1) ? 4 : 2;
					tmp_c[1] = (tmp_c[0] == 4) ? 0 : w;
				}
			}
			while (tmp_cc[0] != s_arr[i][0]) { // counterclockwise check
				if (tmp_cc[0] == 2 || tmp_cc[0] == 3) { // S or W
					counterclock += (tmp_cc[0] == 2) ? w - tmp_cc[1] : h - tmp_cc[1];
					tmp_cc[0] = (tmp_cc[0] == 2) ? 4 : 2;
					tmp_cc[1] = (tmp_cc[0] == 4) ? h : 0;
				}
				else { // N or E
					counterclock += tmp_cc[1];
					tmp_cc[0] = (tmp_cc[0] == 1) ? 3 : 1;
					tmp_cc[1] = (tmp_cc[0] == 3) ? 0 : w;
				}
			}
			clockwise += Math.abs(tmp_c[1] - s_arr[i][1]); // in the same grid
			counterclock += Math.abs(tmp_cc[1] - s_arr[i][1]);
			min += Math.min(clockwise, counterclock);
		}
		sc.close();
		System.out.println(min);
	}

}
