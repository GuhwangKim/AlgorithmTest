package CodingTest.src.study.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_2 {
    public String solution(String p) {
        String answer = check(p);
        // w - u

        // u가 올바른지 확인
        if (answer.startsWith("(")) {
            // 올바른 경우
            check(p.substring(0, p.length()))
        }else{

        }

        return answer;
    }

    private String check(String p) {
        // 일단 처음부터 가능한 경우인지 확인

        Queue<Character> queue = new LinkedList<>();
        queue.add(p.charAt(0));
        int splitIdx = 0;
        // 균형찾기
        for (int i = 1; i < p.length(); i++) {

            if (queue.peek() == '(') {
                if (p.charAt(i) == '(') {
                    queue.add(p.charAt(i));
                }else{
                    //여기서 끝
                    queue.poll();
                }
            } else{
                if (p.charAt(i) == ')') {
                    queue.add(p.charAt(i));
                }else{
                    // 여기서 끝
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
