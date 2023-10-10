package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution46 {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<>();

        // queue 에 글자에 있는 괄호들을 각각 담음
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            char compare = queue.poll();
            checking(compare, queue);
        }


        return answer;
    }

    private void checking(char compare, Queue<Character> queue) {
        // 가장 처음 뽑은 값이 ]}) 인경우 무조건 안됨
        if(compare == ']' || compare == '}' || compare == ')'){
            queue.add(compare);
            // 뽑은 숫자를 가장 마지막에 집어넣고 넘김
            return;
        }

        // 새롭게 검증할 새로운 queue를 만듦
        Queue<Character> queue2 = new LinkedList<>();
        for(char ch : queue){
            queue2.add(ch);
        }
        Stack<Character> stack = new Stack<>();
        stack.add()

        while(!queue2.isEmpty()){


        }




    }
}
