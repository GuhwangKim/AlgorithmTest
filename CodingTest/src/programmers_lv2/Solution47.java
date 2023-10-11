package CodingTest.src.programmers_lv2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution47 {

	class Point {
		long start;
		long end;

		public Point(long start, long end) {
			this.start = start;
			this.end = end;
		}
	}

	public String solution(String play_time, String adv_time, String[] logs) throws ParseException {
		String answer = "";

		// 끝수를 기준으로 집어넣는 queue
		Queue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.end < o2.end) {
					return -1;
				} else if (o1.end > o2.end) {
					return 1;
				} else {
					return 0;
				}

			}
		});

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		// logs에 있는 시간 변환작업
		for (int i = 0; i < logs.length; i++) {
			String[] arr = logs[i].split("-");
			Date start = sdf.parse(arr[0]);
			Date end = sdf.parse(arr[1]);
			queue.add(new Point(start.getTime(), end.getTime()));
		}

		long max = 0;
		int sum = 0;
		Point compare = queue.poll();
		long maxKey = compare.start; // 시작점

		while (!queue.isEmpty()) {
			// 겹쳐지는 개수
			if (compare.end >= queue.peek().start) {
				// 1) 뒤에것과 겹쳐지는 경우
				sum += compare.end - queue.poll().start;// 뒤에것은 없앰

			} else {
				// 2) 뒤에것과 겹쳐지지 않는 경우
				if (max < sum) {
					// 바로 전 개수와 비교를 해서 현재 카운팅이 큰 경우 key max 변화
					max = sum;
					maxKey = compare.start; // 동일한 대상을 비교하기 위함
				}
				compare = queue.poll(); // 비교의 대상이 바뀜
				sum = 0; // 초기화
			}
		}

		// 마지막 cnt 에 대해서
		if (max < sum) {
			maxKey = compare.start;
		}

		answer = change(maxKey);

		return answer;
	}

	// 초를 시분초로 변환
	private String change(long seconds) {

		long hours = Math.floorDiv(seconds, 3600);
		long min = Math.floorDiv((seconds - (hours * 3600)), 60);
		long sec = seconds - hours * 3600 - min * 60;
		return addZero(hours) + ":" + addZero(min) + ":" + addZero(sec);

	}

	private String addZero(long num) {
		return ((num < 10) ? "0" : "") + num;
	}

}
