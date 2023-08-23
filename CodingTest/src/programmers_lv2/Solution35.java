package CodingTest.src.programmers_lv2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution35 {
	
	PriorityQueue<Integer> queue;

	public int solution(int[] cards) {
		int answer = 0;
		boolean[] checked = new boolean[cards.length];

		queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		// ������������ �ڽ��� ���� ��� queue 
		
		for (int i = 0; i < cards.length; i++) {
			if(!checked[i]) {
				// �湮���� �ʾҴٸ� 
				dfs(cards, i, 0, checked);
			}
		}
		
		if(queue.size()>1) {
			// 1�̶�� 1���� ���� �׷츸 �ִ� �� 
			answer = queue.poll() * queue.poll();
		}
		
		return answer;
	}

	private void dfs(int[] cards, int idx, int cnt, boolean[] checked) {
		//���� ���� �� �ٽ� ������ ���� �ϳ��� ���? => ������ ��� �ǵ簣��, �Բ� ���� ���ڵ��� ���� ���δ�
		// ���� ���� ���ڵ鿡 ���� ������ �� �ʿ� ����, ������� ���Ƿ� ���ڸ� �̴� loop�� �ۼ����ָ� �� 
		if(checked[idx]) {
			// �̹� �湮�� 
			queue.add(cnt);
			return;
		}
		checked[idx] = true;
		// �湮����
		dfs(cards, cards[idx]-1, cnt+1, checked);
		
	}

	
}
