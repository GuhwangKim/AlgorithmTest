package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution85 {
    // 이어져있는 문자열 찾기
    public int solution(String s) {
        int answer = -1;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else{
                    stack.add(s.charAt(i));
                }
            }else{
                stack.add(s.charAt(i));
            }
        }

        if (stack.isEmpty()) {
            answer = 1;
        }else{
            answer = 0;
        }
        return answer;
    }
}
