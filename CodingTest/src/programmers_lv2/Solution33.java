package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution33 {
    public int solution(int[] order) {
        int answer = 0;
        /**
         * 보조 컨테이너 = stack 자료형
         * 1 ~ order의 길이 만큼
         * */

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < order.length; i++) {
            if((i+1)==order[i]){
                // list 에 있는 값과 같은 경우 (순서와 같음)
                answer++;
            } else if (!stack.isEmpty() && (i+1) == stack.peek()) {
                // stack 에 있는 값이랑 같은 경우
                stack.pop();
                answer++;
            } else{
                stack.add(i+1);
            }

        }





        return answer;
    }
}
