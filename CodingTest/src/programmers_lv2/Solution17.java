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
        // 시작 시간을 기준으로 오름차순 정렬 
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for(int[] timeArr : time) {
        	if(queue.size()==0) {
        		queue.add(timeArr[1]);
        		// 퇴실 시간을 넣음
        		continue;
        	}
        	if(queue.peek()+10 > timeArr[0] ) {
        		// 청소하고 난 시간이 다음 행 시작시간 보다 더 많이 소요됨 방이 더 필요함
        		queue.add(timeArr[1]);
        	} else {
        		// 청소하고 난 시간이 다음행보다 더 적게 소요되어서 방을 늘릴 필요 없음, 지금 방에 
        		queue.poll();
        		queue.add(timeArr[1]);
        	}
        }
        
        
        
        return queue.size();
    }

}
