package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution46 {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<>();

        // queue �� ���ڿ� �ִ� ��ȣ���� ���� ����
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
        // ���� ó�� ���� ���� ]}) �ΰ�� ������ �ȵ�
        if(compare == ']' || compare == '}' || compare == ')'){
            queue.add(compare);
            // ���� ���ڸ� ���� �������� ����ְ� �ѱ�
            return;
        }

        // ���Ӱ� ������ ���ο� queue�� ����
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
