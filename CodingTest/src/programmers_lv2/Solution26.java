package CodingTest.src.programmers_lv2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution26 {
    /**
     * n <enemy[i] �� �� i �ܰ���� ������
     * k ��ŭ�� ������
     * ������ ���� ��� ������ �������� �ߟG��
     *
     * 1) enemy�� ���� <= k ��� enemy�� ���̸� ����
     * 2) n <enemy[i] �� �� i �ܰ���� ������
     * 3) �׷��� �ʴٸ�
     *      - n-=enemy[i]
     *
     *      - K>0 ��� k-1 ���� i �Ѵܰ� ������
     * */


    public int solution(int n, int k, int[] enemy) {
    	int answer = enemy.length;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (int i = 0; i < enemy.length; i++) {
        	if(n>=enemy[i]) {
        		// 2. ������ ������ �ִ� ������ ������ ����� 
        		n-=enemy[i];
        		queue.add(enemy[i]); // ū ������ ���ĵǰ� ���� 
        	}else {
        		// 3. ������ �� ���� ��Ȳ 
        		if(k>0) {
        			// 4. �������� �ִ� ��� 
        			if(!queue.isEmpty()) {
        				// 4-2. queue �� ���� �ִٸ� 
        				int maxEnemy = queue.poll();
        				if(maxEnemy>enemy[i]) {
        					// 4-3. queue�� ������������ ���ĵǾ��ִ� ���� ���� ���� ���� ���� ������ ũ�� 
        					n+=maxEnemy;
        					// ������ ����ϰ� ȸ�� -> i�� �� �ܰ� ������ 
        					i--;
        				}else {
        					// 4-4. ������ ���� ũ�ٸ� �� ���� �ٽ� queue �� ������� 
        					queue.add(maxEnemy);
        				}
        			}
        			// 4. ������ ��� 
        			k--;
        		} else {
        			// 5. ���������� ���� ��� -> stop
        			answer = i;
        			// �� ���������� ������ �� ���� 
        			break;
        		}
        	}
		}
        
        return answer;
    }


}
