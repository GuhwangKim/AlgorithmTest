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
		// 내림차순으로 박스의 수를 담는 queue 
		
		for (int i = 0; i < cards.length; i++) {
			if(!checked[i]) {
				// 방문하지 않았다면 
				dfs(cards, i, 0, checked);
			}
		}
		
		if(queue.size()>1) {
			// 1이라면 1개의 상자 그룹만 있는 것 
			answer = queue.poll() * queue.poll();
		}
		
		return answer;
	}

	private void dfs(int[] cards, int idx, int cnt, boolean[] checked) {
		//남은 상자 중 다시 임의의 상자 하나를 골라? => 순서가 어떻게 되든간에, 함께 묶일 상자들은 같이 묶인다
		// 따라서 남은 상자들에 대한 검증은 할 필요 없고, 순서대로 임의로 상자를 뽑는 loop만 작성해주면 됨 
		if(checked[idx]) {
			// 이미 방문함 
			queue.add(cnt);
			return;
		}
		checked[idx] = true;
		// 방문했음
		dfs(cards, cards[idx]-1, cnt+1, checked);
		
	}

	
}
