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
            // �Է°��� �� ���ڿ��̸�
            return "";
        }
        // ������ ���� ���ڿ�
        int left = 0;
        String strLeft = "";
        int right = 0;
        String strRight = "";

        for (int i = 0; i < p.length(); i++) {
            // 1. ���� ����
            if (p.charAt(i) == ')') {
                left++;
            } else{
                right++;
            }
            // 2. ���� ����
            strLeft += p.charAt(i); // u

            if (left == right) {
                // ������ ���ٸ� ��������
                strRight += p.substring(i + 1); // v ������ ����
                break;
            }
        }

        // u�� ���� �ùٸ� ���ڿ����� Ȯ��
        if (isCorrect(strLeft)) {
            // �ùٸ� ���
            return strLeft + check(strRight); //v�� ���ؼ� 1���� �ݺ�
        } else{
            // �ùٸ��� ������
            String temp = "(";
            temp += check(strRight);
            temp += ")";
            // ������
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
                // �ùٸ� �� �ִ� ���
                stack.push('(');
            }else{
                // )�� ó������ ������ ��� = �ùٸ��� �ʴ� ���
                if (stack.isEmpty() || stack.peek() == ')') {
                    return false;
                }else{
                    // ( �ڿ� ���ͼ� �������� ���
                    stack.pop();
                }
            }
        }
        return true;
    }
}
