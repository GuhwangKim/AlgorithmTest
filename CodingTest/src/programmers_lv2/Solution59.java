package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.List;

public class Solution59 {
    public long solution(String expression) {
        long answer = 0;
        /*
        * �� 6������ �켱���� ����� ���� ����
        * expression�� �׷��� ���� ���� ó������ �ϳ��� ��������
        * + - * �� �߽����� ������,
        * �����ڴ� Ȧ�� �ε������� �����Ѵ�
        * loop�� Ȧ�� ���������� �ݺ��Ѵ�
        * loop�� �� ������ ������ �������� �ּ� ���� ���ؼ� ��ü�Ѵ�
        * 
        *
        * arr�� �־��ְ�, visited ���� ���� �����
        * */
        String[] count = expression.split("\\+|-|\\*");
        String[] arr = new String[count.length + ]

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*'){
                // ��ȣ�� �ִٸ� �ǳʶپ�� �ϰ�, �� �������� ������, �ʱ�ȭ ��Ŵ
                list.add(String.valueOf(stringBuilder));
                list.add(String.valueOf(expression.charAt(i)));
                stringBuilder = new StringBuilder();
                continue;
            }
            stringBuilder.append(expression.charAt(i));
        }
        String[] operation = {"+", "-", "*"};
        for (int i = 0; i < operation.length; i++) {
            // + - * ������ �Ѱܺ�
            DFS(operation[i], list);
        }

        return answer;
    }

    private void DFS(String firstOperation, List<String> list) {

        // ���� ���� ���;��ϴ� operation
        for (int i = 1; i < list.size()-1; i+=2) {
            // ���꿡 ���ؼ��� ����
            if(list.get(i)==firstOperation){
                // ó���� �ؾ��ϴ� ����
                int frontNum = Integer.parseInt(list.get(i-1));
                int backNum = Integer.parseInt(list.get(i+1));

                String operatedNum ="";
                if(firstOperation.equals("+")){
                    operatedNum = String.valueOf(frontNum+backNum);
                } else if (firstOperation.equals("-")) {
                    operatedNum = String.valueOf(frontNum-backNum);
                } else {
                    operatedNum = String.valueOf(frontNum*backNum);
                }

                list.re


            }
        }

    }
}
