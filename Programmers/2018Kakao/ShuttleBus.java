import java.io.*;
import java.util.*;

// 프로그래머스 2018 KAKAO 셔틀버스

public class ShuttleBus {
	static class Time implements Comparable<Time> {
		int hour, min;
		
		Time(String t) {
			StringTokenizer st = new StringTokenizer(t, ":");
			String h = st.nextToken();
			hour = Integer.parseInt(h);
			
			String m = st.nextToken();
			min = Integer.parseInt(m);		
		}
		
		Time(int h, int m) {
			hour = h;
			min = m;
		}
		
		public Time addTime(int m) {
			this.min += m;
			if (this.min >= 60) {
				this.hour += 1;
				this.min -= 60;
			}
			return this;
		}
		
		public Time subTime() {
			this.min -= 1;
			if (this.min < 0) {
				this.hour -= 1;
				this.min = 59;
			}
			return this;
		}
		
		@Override
		public String toString() {
			String h = "";
			if (hour < 10) h = "0";
			h += Integer.toString(hour);
			
			String m = "";
			if (min < 10) m = "0";
			m += Integer.toString(min);
			
			return h + ":" + m;
		}

		@Override
		public int compareTo(Time o) {
			if (this.hour == o.hour) return this.min - o.min;
			return this.hour - o.hour;
		}
	}

	public static void main(String[] args) {
		int n = 2;
		int t = 10;
		int m = 2;
		String[] timetable = {"09:10", "09:09", "08:00"};

		solution(n, t, m, timetable);
	}

	private static void solution(int n, int t, int m, String[] timetable) {
		PriorityQueue<Time> table = new PriorityQueue<>();
		LinkedList<Time> bus;
		Time start = new Time("09:00");
		Time res = null;
		
		for (int i = 0; i < timetable.length; i++) {
			table.offer(new Time(timetable[i]));
		}
		
		for (int i = 0; i < n; i++) {
			bus = new LinkedList<>();
			int idx = 0;
			while (idx < m && !table.isEmpty() && table.peek().compareTo(start) <= 0) {
				bus.offer(table.poll());
				idx++;
			}
			if (idx == m) {
				res = bus.pollLast().subTime();
			}
			else {
				res = new Time(start.hour, start.min);
			}
			start = start.addTime(t);
		}
		
		System.out.println(res.toString());
	}

}
