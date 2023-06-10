package programmers_lv2;

import java.util.Arrays;

public class Solution7 {
	public int solution(int[][] targets) {
        int answer = 1;
        /**
         * 1. �� ������ ���� 
         * 2. �տ� ���ڰ� �� �� ������ ������ ������ �� ���ų� �� ũ�� �ϳ� �߰� -> �������� �� ���� �迭�� �������� �ٲ� 
         * 3. �׳� ������ �Ѿ 
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
