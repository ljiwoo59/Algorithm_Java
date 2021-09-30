import java.util.*;

// 프로그래머스 Hash > 베스트앨범

public class Hash_BestAlbum {

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic","jazz","pop", "Rock", "jazz"};
		int[] plays = {500, 600, 150, 800, 1100, 2500, 100, 1000};
		
		int[] result = Solution(genres, plays);
		
		System.out.println(Arrays.toString(result));
	}

	static class Song implements Comparable<Song>{
		int playtime, no;
		
		Song(int playtime, int no) {
			this.playtime = playtime;
			this.no = no;
		}

		@Override
		public int compareTo(Song o) {
			if (this.playtime == o.playtime) return this.no - o.no;
			return o.playtime - this.playtime;
		}
	}
	
	private static int[] Solution(String[] genres, int[] plays) {
		Map<String, PriorityQueue<Song>> list = new TreeMap<>();
		Map<String, Integer> totCnt = new TreeMap<>();
		int size = genres.length;
		
		for (int i = 0; i < size; i++) {
			String g = genres[i];
			if (list.containsKey(g)) {
				list.get(g).add(new Song(plays[i], i));
			}
			else {
				PriorityQueue<Song> val = new PriorityQueue<>();
				list.put(g, val);
				val.add(new Song(plays[i], i));
			}
			if (totCnt.containsKey(g)) totCnt.put(g, totCnt.get(g) + plays[i]);
			else totCnt.put(g, plays[i]);
		}
	
		ArrayList<Integer> tmp = new ArrayList<>();
		while (totCnt.size() > 0) {
			String maxG = "";
			int maxCnt = 0;
			for (Map.Entry<String, Integer> e : totCnt.entrySet()) {
				if (e.getValue() > maxCnt) {
					maxG = e.getKey();
					maxCnt = e.getValue();
				}
			}
			totCnt.remove(maxG);
			
			PriorityQueue<Song> selected = list.get(maxG);
			
			tmp.add(selected.poll().no);
			if (!selected.isEmpty()) tmp.add(selected.poll().no);	
		}
		
		int[] answer = new int[tmp.size()];
		for (int j = 0; j < answer.length; j++) {
			answer[j] = tmp.get(j);
		}
		
		return answer;
	}

}
