package CodingTest.src.study.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Level2_2 {
    public String solution(String p) {
        String answer = check(p);

        return answer;
    }

    private String check(String p) {
        if (p.length() == 0) {
            // 입력값이 빈 문자열이면
            return "";
        }
        // 개수와 조합 문자열
        int left = 0;
        String strLeft = "";
        int right = 0;
        String strRight = "";

        for (int i = 0; i < p.length(); i++) {
            // 1. 개수 연산
            if (p.charAt(i) == ')') {
                left++;
            } else{
                right++;
            }
            // 2. 문자 조합
            strLeft += p.charAt(i); // u

            if (left == right) {
                // 개수가 같다면 균형잡힘
                strRight += p.substring(i + 1); // v 균형을 제외
                break;
            }
        }

        // u에 대한 올바른 문자열인지 확인
        if (isCorrect(strLeft)) {
            // 올바른 경우
            return strLeft + check(strRight); //v에 대해서 1번을 반복
        } else{
            // 올바르지 않으면
            String temp = "(";
            temp += check(strRight);
            temp += ")";
            // 뒤집기
            String operation = strLeft.substring(1, strLeft.length() - 1);
            String operationResult = "";
            for (int i = 0; i < operation.length(); i++) {
                if (operation.charAt(i) == ')') {
                    operationResult += '(';
                }else{
                    operationResult += ')';
                }
            }
            return temp += operationResult;
        }
        
        
    }

    private boolean isCorrect(String strLeft) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < strLeft.length(); i++) {
            if (strLeft.charAt(i) == '(') {
                // 올바를 수 있는 경우
                stack.push('(');
            }else{
                // )가 처음으로 나오는 경우 = 올바르지 않는 경우
                if (stack.isEmpty() || stack.peek() == ')') {
                    return false;
                }else{
                    // ( 뒤에 나와서 없어지는 경우
                    stack.pop();
                }
            }
        }
        return true;
    }
}
