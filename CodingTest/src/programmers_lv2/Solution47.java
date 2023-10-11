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

		// ������ �������� ����ִ� queue
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

		// logs�� �ִ� �ð� ��ȯ�۾�
		for (int i = 0; i < logs.length; i++) {
			String[] arr = logs[i].split("-");
			Date start = sdf.parse(arr[0]);
			Date end = sdf.parse(arr[1]);
			queue.add(new Point(start.getTime(), end.getTime()));
		}

		long max = 0;
		int sum = 0;
		Point compare = queue.poll();
		long maxKey = compare.start; // ������

		while (!queue.isEmpty()) {
			// �������� ����
			if (compare.end >= queue.peek().start) {
				// 1) �ڿ��Ͱ� �������� ���
				sum += compare.end - queue.poll().start;// �ڿ����� ����

			} else {
				// 2) �ڿ��Ͱ� �������� �ʴ� ���
				if (max < sum) {
					// �ٷ� �� ������ �񱳸� �ؼ� ���� ī������ ū ��� key max ��ȭ
					max = sum;
					maxKey = compare.start; // ������ ����� ���ϱ� ����
				}
				compare = queue.poll(); // ���� ����� �ٲ�
				sum = 0; // �ʱ�ȭ
			}
		}

		// ������ cnt �� ���ؼ�
		if (max < sum) {
			maxKey = compare.start;
		}

		answer = change(maxKey);

		return answer;
	}

	// �ʸ� �ú��ʷ� ��ȯ
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
