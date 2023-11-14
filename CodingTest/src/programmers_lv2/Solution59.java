package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution59 {
    public long solution(String expression) {
        long answer = Long.MIN_VALUE;

        String op[][] = { { "+", "-", "*" }, { "+", "*", "-" }, { "-", "*", "+" },
                { "-", "+", "*" }, { "*", "-", "+" }, { "*", "+", "-" } };

        ArrayList<String> list = new ArrayList<>();
        
        int start = 0;
        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*'){
                // �����ڶ��
                list.add(expression.substring(start, i));
                // ������ �տ� ���ڸ� �������
                list.add(expression.charAt(i)+"");
                // �����ڸ� �������
                start = i+1;
                // ���� ����Ʈ�� ������ �� �������� ��
            }
        }
        list.add(expression.substring(start));

        for (int i = 0; i < op.length; i++) {
            // �������� ���� ����
            ArrayList<String> subList = new ArrayList<>(list);
            for (int j = 0; j < 3; j++) {
                // �������� ���� 3��
                for (int k = 0; k < subList.size(); k++) {
                    if(op[i][j].equals(subList.get(k))){
                        // ���� ���ڰ� �������� ��
                        subList.set(k-1, cal(subList.get(k-1),subList.get(k), subList.get(k+1)));
                        // k -1 ���� k ������ k+1 ���ڸ� �Ѱܼ� ����� �� , k-1 ��ġ�� ����
                        subList.remove(k);
                        // k������ ����
                        subList.remove(k);
                        // 2���� ���������Ƿ�, ���� 2���� ���ܽ�Ŵ
                        k--;
                    }
                }
            }
            // ������ ������ ���� �� ���� ���� ����
            // ��� �Ŀ� ���� �ϳ��� ����
            answer = Math.max(answer, Math.abs(Long.parseLong(subList.get(0))));
        }


        return answer;
    }

    private String cal(String num1, String op, String num2) {
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);
        if(op.equals("+")){
            return n1+n2+"";
        }
        if(op.equals("-")){
            return n1-n2+"";
        }
        return n1*n2+"";
    }
}
