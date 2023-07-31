package CodingTest.src.programmers_lv2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution26 {
    /**
     * n <enemy[i] 일 떄 i 단계까지 가능함
     * k 만큼은 보장함
     * 나머지 값을 어떻게 조합할 것인지가 중욯마
     *
     * 1) enemy의 길이 <= k 라면 enemy의 길이를 리턴
     * 2) n <enemy[i] 일 떄 i 단계까지 가능함
     * 3) 그렇지 않다면
     *      - n-=enemy[i]
     *
     *      - K>0 라면 k-1 쓰고 i 한단계 띄어넘음
     * */


    public int solution(int n, int k, int[] enemy) {
    	int answer = enemy.length;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (int i = 0; i < enemy.length; i++) {
        	if(n>=enemy[i]) {
        		// 2. 적보다 가지고 있는 병력이 많으면 상대함 
        		n-=enemy[i];
        		queue.add(enemy[i]); // 큰 순으로 정렬되고 있음 
        	}else {
        		// 3. 병력이 더 많은 상황 
        		if(k>0) {
        			// 4. 무적권이 있는 경우 
        			if(!queue.isEmpty()) {
        				// 4-2. queue 에 값이 있다면 
        				int maxEnemy = queue.poll();
        				if(maxEnemy>enemy[i]) {
        					// 4-3. queue에 내림차순으로 정렬되어있는 적의 수가 현재 들어온 적의 수보다 크면 
        					n+=maxEnemy;
        					// 무적권 사용하고 회복 -> i도 한 단계 앞으로 
        					i--;
        				}else {
        					// 4-4. 현재의 값이 크다면 그 값을 다시 queue 에 집어넣음 
        					queue.add(maxEnemy);
        				}
        			}
        			// 4. 무적권 사용 
        			k--;
        		} else {
        			// 5. 무적권조차 없는 경우 -> stop
        			answer = i;
        			// 이 순서까지만 진행할 수 있음 
        			break;
        		}
        	}
		}
        
        return answer;
    }


}
