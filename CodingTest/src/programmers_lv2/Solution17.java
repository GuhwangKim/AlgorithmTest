package programmers_lv2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution17 {
	public int solution(String[][] book_time) {
        int[][] time = new int[book_time.length][2];
        
        
        for (int i = 0; i < book_time.length; i++) {
			for (int j = 0; j <= 1; j++) {
				String[] split = book_time[i][j].split(":");
				int arrTime = Integer.parseInt((split[0]))*60 + Integer.parseInt(split[1]);
				time[i][j] = arrTime;
			}
		}
        
        Arrays.sort(time, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        // ���� �ð��� �������� �������� ���� 
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for(int[] timeArr : time) {
        	if(queue.size()==0) {
        		queue.add(timeArr[1]);
        		// ��� �ð��� ����
        		continue;
        	}
        	if(queue.peek()+10 > timeArr[0] ) {
        		// û���ϰ� �� �ð��� ���� �� ���۽ð� ���� �� ���� �ҿ�� ���� �� �ʿ���
        		queue.add(timeArr[1]);
        	} else {
        		// û���ϰ� �� �ð��� �����ຸ�� �� ���� �ҿ�Ǿ ���� �ø� �ʿ� ����, ���� �濡 
        		queue.poll();
        		queue.add(timeArr[1]);
        	}
        }
        
        
        
        return queue.size();
    }

}
