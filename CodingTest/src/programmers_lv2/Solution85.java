package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution85 {
    // 이어져있는 문자열 찾기
    public int solution(String s) {
        int answer = -1;

        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (!queue.isEmpty()) {
                if (queue.peek() == s.charAt(i)) {
                    queue.poll();
                } else{
                    queue.add(s.charAt(i));
                }
            }
        }

        if (queue.isEmpty()) {
            answer = 1;
        }else{
            answer = 0;
        }

        return answer;
    }
}
