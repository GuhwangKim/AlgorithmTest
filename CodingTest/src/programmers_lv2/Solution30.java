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
        		// ¦�����
        		k/=2;
        	}else {
        		k*=3;
        		k++;
        	}
    		list.add(k);
        }
        
        double[] eachSize = new double[list.size()-1];
        
        // ��ǥ �ϳ��ϳ� ������ �簢���� �ʺ� ������ 
        // ������ ���� -1 ���� ���� 
        for (int i = 0; i < list.size()-1; i++) {
			eachSize[i] = (double)(list.get(i) + list.get(i+1))/2;
			// ** ���̸� �����ϴ� ����� �𸣰��� 
			// => {(����)+(�Ʒ���)}��(����) �� 2
		}
        
        for (int i = 0; i < ranges.length; i++) {
			double result = 0;
			int start = ranges[i][0];
			int end = list.size()+ranges[i][1]-1;
			// ** ���⼭ �� -1 �ϴ���? 
			// => �Ʒ� ������ �� �� end ���� �������� �ʱ� ����
			
			if(start>end) {
				answer[i] = -1;
				/// ��ȿ���� ���� �� 
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
