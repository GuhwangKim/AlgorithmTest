package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution46 {
    public int solution(String s) {
        int answer = -1;
        Queue<Character> queue = new LinkedList<>();

        // queue 에 글자에 있는 괄호들을 각각 담음
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            char compare = queue.poll();
            if(compare == '['){
                
            } else if (compare==) {
                
            }
        }


        return answer;
    }
}
