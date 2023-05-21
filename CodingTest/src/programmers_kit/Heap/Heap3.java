package programmers_kit.Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Heap3 {
	public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        solution(operations);
    }
	public static int[] solution(String[] operations) {
		int[] answer = new int[2];
		PriorityQueue<Integer> queueMin = new PriorityQueue<>();
		// �⺻������ �������� (�ּҰ�~)
		PriorityQueue<Integer> queueMax = new PriorityQueue<>(Collections.reverseOrder());
		// �������� (�ִ밪~ )

		for (int i = 0; i < operations.length; i++) {
			StringTokenizer st = new StringTokenizer(operations[i]);
            String firstWord = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            
            // 3. queue �� ���� �ִ� ��쿣 �ִ� �ּ� ���� ����
			if(queueMin.size()<1 && firstWord.equals("D")) {
				continue;
			}
			
			if (firstWord.equals("I")) {
				// 1. I�� ������ �������
				queueMax.add(number);
				queueMin.add(number);
				continue;
			}

			// 2. D�� ���ö�
			if (number<0) {
				int numMin = queueMin.poll();
				queueMax.remove(numMin);
			} else {
				int numMax = queueMax.poll();
				queueMin.remove(numMax);

			}
		}
		if (queueMin.size() > 0) {
			answer[0] = queueMax.peek();
			answer[1] = queueMin.peek();
		}

		return answer;
	}

}
