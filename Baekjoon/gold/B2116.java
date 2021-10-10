package gold;

import java.io.*;
import java.util.*;

// 백준 2116 주사위 쌓기 Gold 5

public class B2116 {
	static class Dice {
		int[] idxNum; // 인덱스 당 숫자
		int[] numIdx; // 숫자 당 인덱스
		
		Dice(StringTokenizer st) {
			idxNum = new int[6];
			numIdx = new int[7];
			for (int i = 0; i < 6; i++) {
				int now = Integer.parseInt(st.nextToken());
				idxNum[i] = now;
				numIdx[now] = i;
			}
		}
	}
	
	static int N, result;
	static Dice[] dices;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dices = new Dice[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dices[i] = new Dice(st);
		}

		for (int i = 0; i < 6; i++) { // 인덱스 0, 1, 2 만 시도 (3, 4, 5 와 옆면이 같음)
			int tot = 6; // 한 시도당 모든 주사위 최대 옆면 합
			// 제일 아래 주사위
			int nextBot = 0; // 다음 주사위의 바닥 숫자 == 현 주사위 천장 숫자
			if (i == 0) {
				nextBot = dices[0].idxNum[5];
				while (tot == dices[0].idxNum[i] || tot == nextBot) tot--;
			}
			else if (i == 1) {
				nextBot = dices[0].idxNum[3];
				while (tot == dices[0].idxNum[i] || tot == nextBot) tot--;
			}
			else if (i == 2) {
				nextBot = dices[0].idxNum[4];
				while (tot == dices[0].idxNum[i] || tot == nextBot) tot--;
			}
			else if (i == 3) {
				nextBot = dices[0].idxNum[1];
				while (tot == dices[0].idxNum[i] || tot == nextBot) tot--;
			}
			else if (i == 4) {
				nextBot = dices[0].idxNum[2];
				while (tot == dices[0].idxNum[i] || tot == nextBot) tot--;
			}
			else {
				nextBot = dices[0].idxNum[0];
				while (tot == dices[0].idxNum[i] || tot == nextBot) tot--;
			}
	
			for (int j = 1; j < N; j++) {
				int max = 6; // 주사위 당 최대 옆면
				int idx = dices[j].numIdx[nextBot];
				if (idx == 0) {
					nextBot = dices[j].idxNum[5];
					while (max == dices[j].idxNum[idx] || max == nextBot) max--;
				}
				else if (idx == 1) {
					nextBot = dices[j].idxNum[3];
					while (max == dices[j].idxNum[idx] || max == nextBot) max--;
				}
				else if (idx == 2) {
					nextBot = dices[j].idxNum[4];
					while (max == dices[j].idxNum[idx] || max == nextBot) max--;
				}
				else if (idx == 3) {
					nextBot = dices[j].idxNum[1];
					while (max == dices[j].idxNum[idx] || max == nextBot) max--;
				}
				else if (idx == 4) {
					nextBot = dices[j].idxNum[2];
					
					while (max == dices[j].idxNum[idx] || max == nextBot) max--;
				}
				else {
					nextBot = dices[j].idxNum[0];
					while (max == dices[j].idxNum[idx] || max == nextBot) max--;
				}
				
				tot += max;
			}
			
			result = Math.max(result, tot);
		}
		
		System.out.println(result);
	}

}
