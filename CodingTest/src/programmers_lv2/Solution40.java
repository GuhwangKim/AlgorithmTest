package programmers_lv2;

import java.util.*;

public class Solution40 {

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

	public static void main(String[] args) {
		Solution40 solution40 = new Solution40();
		int[][] arr = { { 2, -1, 4 }, { -2, -1, 4 }, { 0, -1, 1 }, { 5, -8, -12 }, { 5, 8, 12 } };
		solution40.solution(arr);
	}

	static Set<Point> set;
	int minX, maxX, minY, maxY;

	public String[] solution(int[][] line) {
		/**
		 * 구하는 방정식의 교점을 구하는 자체 메소드
		 */
		// 1. 정수인 교차점을 구하는 방법
		set = new HashSet<>();
		for (int i = 0; i < line.length - 1; i++) {
			for (int j = i + 1; j < line.length; j++) {
				// 총 라인을 2개씩 각각 비교해줌
				long a = line[i][0], b = line[i][1], c = line[i][2];
				long d = line[j][0], e = line[j][1], f = line[j][2];
				long divideBottom = a * e - b * d;
				if (divideBottom != 0) {
					// 0이 아니면 나눌 수 있기 때문
					long dividedX = b * f - c * e;
					// y의 값을 연산
					long dividedY = c * d - a * f;
					// y의 값을 연산
					if (dividedX % divideBottom == 0 && dividedY % divideBottom == 0) {
						// 나누어 떨어진다 = 정수

						set.add(new Point((int) dividedX / (int) divideBottom, (int) dividedY / (int) divideBottom));
					}
				}
			}
		}
//       for(Point p : set) {
//    	   System.out.println("x :"+p.x);
//    	   System.out.println("y :"+p.y);
//    	   
//       }

		// 2. 교점 x, y의 최대치를 구해서 그 안에서만 교점이 표시 되면 됨
		getSize(set.size());
		String[] answer = new String[maxY - minY + 1];// 위치 0
		StringBuilder sb;
		for (int i = maxY, idx = 0; i >= minY; i--) {
			sb = new StringBuilder();
			for (int j = minX; j <= maxX; j++) {
				if (set.contains(new Point(j, i)))
					sb.append("*");
				else
					sb.append(".");
			}
			answer[idx++] = sb.toString();
		}
		return answer;
	}

	private void getSize(int size) {
		List<Point> list = new LinkedList<>(set);

		// x를 기준으로 최대 최소
		Collections.sort(list, (o1, o2) -> o1.x - o2.x);
		minX = list.get(0).x;
		maxX = list.get(size - 1).x;
		Collections.sort(list, (o1, o2) -> o1.y - o2.y);
		minY = list.get(0).y;
		maxY = list.get(size - 1).y;
	}
}
