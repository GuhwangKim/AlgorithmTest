package CodingTest.src.study.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_2 {
    public String solution(String p) {
        String answer = check(p);
        // w - u

        // u�� �ùٸ��� Ȯ��
        if (answer.startsWith("(")) {
            // �ùٸ� ���
            check(p.substring(0, p.length()))
        }else{

        }

        return answer;
    }

    private String check(String p) {
        // �ϴ� ó������ ������ ������� Ȯ��

        Queue<Character> queue = new LinkedList<>();
        queue.add(p.charAt(0));
        int splitIdx = 0;
        // ����ã��
        for (int i = 1; i < p.length(); i++) {

            if (queue.peek() == '(') {
                if (p.charAt(i) == '(') {
                    queue.add(p.charAt(i));
                }else{
                    //���⼭ ��
                    queue.poll();
                }
            } else{
                if (p.charAt(i) == ')') {
                    queue.add(p.charAt(i));
                }else{
                    // ���⼭ ��
                    queue.poll();
                }
            }
            if (queue.isEmpty()) {
                splitIdx = i;
                break;
            }
        }

        return p.substring(0, splitIdx);

    }
}
