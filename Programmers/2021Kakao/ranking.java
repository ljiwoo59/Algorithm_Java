import java.util.*;

public class ranking {
	static ArrayList<Integer>[][][][] score = new ArrayList[3][2][2][2];
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		solution(info, query);
		
	}

	private static void solution(String[] info, String[] query) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				for (int j2 = 0; j2 < 2; j2++) {
					for (int k = 0; k < 2; k++) {
						score[i][j][j2][k] = new ArrayList<>();
					}
				}
			}
		}
		
		int infoLen = info.length;
		int qLen = query.length;
		int[] answer = new int[qLen];
		
		for (int i = 0; i < infoLen; i++) {
			StringTokenizer st = new StringTokenizer(info[i], " ");
			String lang = st.nextToken();
			String job = st.nextToken();
			String exp = st.nextToken();
			String food = st.nextToken();
			int sc = Integer.parseInt(st.nextToken());
			int l, j, e, f;
			
			if (lang.equals("cpp")) l = 0;
			else if (lang.equals("java")) l = 1;
			else l = 2;
			if (job.equals("backend")) j = 0;
			else j = 1;
			if (exp.equals("junior")) e = 0;
			else e = 1;
			if (food.equals("chicken")) f = 0;
			else f = 1;
			
			score[l][j][e][f].add(sc);	
		}
		
		int sl = 0, el = 2, sj = 0, ej = 1, se = 0, ee = 1, sf = 0, ef = 1, sc = 0;
		for (int i = 0; i < qLen; i++) {
			sl = sj = se = sf = sc = 0;
			ej = ee = ef = 1;
			el = 2;
			StringTokenizer st = new StringTokenizer(query[i], " ");
			for (int k = 0; k < 8; k++) {
				String curr = st.nextToken();
				if (curr.equals("and")) continue;
				if (curr.equals("-")) continue;
				else if (curr.equals("cpp")) sl = el = 0;
				else if (curr.equals("java")) sl = el = 1;
				else if (curr.equals("python")) sl = el = 2;
				else if (curr.equals("backend")) sj = ej = 0;
				else if (curr.equals("frontend")) sj = ej = 1;
				else if (curr.equals("junior")) se = ee = 0;
				else if (curr.equals("senior")) se = ee = 1;
				else if (curr.equals("chicken")) sf = ef = 0;
				else if (curr.equals("pizza")) sf = ef = 1;
				else sc = Integer.parseInt(curr);
			}
			
			int count = 0;
			for (int j = sl; j < el + 1; j++) {
				for (int j2 = sj; j2 < ej + 1; j2++) {
					for (int k = se; k < ee + 1; k++) {
						for (int k2 = sf; k2 < ef + 1; k2++) {
							for (int s : score[j][j2][k][k2]) {
								if (s >= sc) count++;
								//System.out.println("i: " + i + " hi");
							}
						}
					}
				}
			}
			
			answer[i] = count;
	
		}
		
		System.out.println(Arrays.toString(answer));
	}

}
