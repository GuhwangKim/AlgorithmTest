package programmers; // ���� ���ڴ� �Ⱦ�

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        List<Integer> list=new ArrayList<Integer>();
        
        int last=-1;
        
        for (int i = 0; i < arr.length; i++) {
			if(last!=arr[i]) {
				list.add(last);
				// list �� ������ ����, ������� ���� �� add �ڿ� ���� ���� ��
				last=arr[i];
			}
		}
        
        for (int i = 0; i < answer.length; i++) {
			answer[i]=list.get(i);
		}
        
        // [����] ��ư�� ������ ��� ���� �� �� �ֽ��ϴ�.
        System.out.println(answer);
        return answer;
    }
}