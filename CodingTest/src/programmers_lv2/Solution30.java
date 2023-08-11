package programmers_lv2;

import java.util.LinkedList;
import java.util.List;

public class Solution30 {
	public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new LinkedList<Integer>();
        list.add(k);
        
        while(k!=1) {
        	if(k%2==0) {
        		// 짝수라면
        		k/=2;
        	}else {
        		k*=3;
        		k++;
        	}
    		list.add(k);
        }
        
        double[] eachSize = new double[list.size()-1];
        
        // 좌표 하나하나 마다의 사각형의 너비를 구해줌 
        // 사이즈 보다 -1 개가 나옴 
        for (int i = 0; i < list.size()-1; i++) {
			eachSize[i] = (double)(list.get(i) + list.get(i+1))/2;
			// ** 넓이를 연산하는 방법을 모르겠음 
			// => {(윗변)+(아랫변)}×(높이) ÷ 2
		}
        
        for (int i = 0; i < ranges.length; i++) {
			double result = 0;
			int start = ranges[i][0];
			int end = list.size()+ranges[i][1]-1;
			// ** 여기서 왜 -1 하는지? 
			// => 아래 루프문 돌 때 end 값은 포함하지 않기 때문
			
			if(start>end) {
				answer[i] = -1;
				/// 유효하지 않은 값 
			} else {
				for (int j = start; j < end; j++) {
					result += eachSize[j];
				}
				answer[i] = result;
			}
		}
        return answer;
    }
}
