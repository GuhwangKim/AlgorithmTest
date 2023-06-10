package programmers_lv2;

import java.util.Arrays;

public class Solution7 {
	public int solution(int[][] targets) {
        int answer = 1;
        /**
         * 1. 끝 값으로 정렬 
         * 2. 앞에 글자가 그 전 글자의 끝값과 비교했을 때 같거나 더 크면 하나 추가 -> 기준점은 그 다음 배열의 끝값으로 바뀜 
         * 3. 그냥 작으면 넘어감 
         * */
         Arrays.sort(targets, (o1, o2)-> o1[1]-o2[1]);
        int compareNum = targets[0][1];
        
       
        
        for (int i = 1; i < targets.length; i++) {
			if(compareNum<=targets[i][0]) {
				answer++;
				compareNum = targets[i][1];
			}else {
				continue;
				
			}
		}
        
        return answer;
    }

}
