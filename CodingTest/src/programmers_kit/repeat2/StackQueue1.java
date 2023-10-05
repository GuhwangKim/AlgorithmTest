package programmers_kit.repeat2;

import java.util.LinkedList;
import java.util.List;

public class StackQueue1 {
	public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
			int x = 1;
			while(true) {
				if(progresses[i]+speeds[i]*x>=100) {
					break;
				}else {
					x++;
				}
			}
			answer[i] = x;
		}
        List<Integer> list = new LinkedList<Integer>();
        
        int cnt = 0;
        for (int i = 0; i < answer.length-1; i++) {
			if(answer[i]>=answer[i+1]) {
				cnt++;
			}else {
				if(cnt>0) {
					list.add(cnt);
					
				}
			}
		}
        
        
        
        
        return answer;
    }

}
