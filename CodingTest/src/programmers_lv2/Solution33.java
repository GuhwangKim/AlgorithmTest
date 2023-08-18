package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution33 {
    public int solution(int[] order) {
        int answer = 0;
        /**
         * ���� �����̳� = stack �ڷ���
         * 1 ~ order�� ���� ��ŭ
         * */

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < order.length; i++) {
            if((i+1)==order[i]){
                // list �� �ִ� ���� ���� ��� (������ ����)
                answer++;
            } else if (!stack.isEmpty() && (i+1) == stack.peek()) {
                // stack �� �ִ� ���̶� ���� ���
                stack.pop();
                answer++;
            } else{
                stack.add(i+1);
            }

        }





        return answer;
    }
}
