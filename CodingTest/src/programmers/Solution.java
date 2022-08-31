package programmers; // 같은 숫자는 싫어

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        List<Integer> list=new ArrayList<Integer>();
        
        int last=-1;
        
        for (int i = 0; i < arr.length; i++) {
			if(last!=arr[i]) {
				list.add(last);
				// list 는 순서가 있음, 순서대로 들어가게 됨 add 뒤에 오는 것은 값
				last=arr[i];
			}
		}
        
        for (int i = 0; i < answer.length; i++) {
			answer[i]=list.get(i);
		}
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);
        return answer;
    }
}