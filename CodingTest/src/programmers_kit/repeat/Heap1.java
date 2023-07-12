package programmers_kit.repeat;

import java.util.PriorityQueue;

/**
 * ���� ����Ϸ��� ������������ �����ؼ� ���� ������� Ʈ���� Ÿ���� 
 * PriorityQueue �� ����ϸ� �ڵ� ����
 * queue �� ��� poll �ϸ鼭 ������ �����̹Ƿ� ���⿡���� BFS DFS �� ���� ��Ͱ� �ʿ� ���� 
 * queue �� size �� 1 ���Ͽ��� 2���� ���ڸ� ���� �� ���� ��쵵 ������ ������� 
 * 
 * */

public class Heap1 {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int num : scoville) {
			queue.add(num);
		}
		
		while(queue.peek()<K) {
			if(queue.size()==1) {
				return -1;
			}else {
				queue.add(queue.poll()+(queue.poll()*2));
				answer++;
			}
		}
		return answer;

	}



}
