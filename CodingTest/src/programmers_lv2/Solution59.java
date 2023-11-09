package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.List;

public class Solution59 {
    public long solution(String expression) {
        long answer = 0;
        /*
        * 총 6가지의 우선순의 경우의 수가 있음
        * expression이 그렇게 길지 않음 처음부터 하나씩 추출하자
        * + - * 를 중심으로 나누고,
        * 연산자는 홀수 인덱스에만 존재한다
        * loop를 홀수 연산자으로 반복한다
        * loop를 돌 떄마다 총합의 연산자의 최소 값을 비교해서 교체한다
        * 
        *
        * arr에 넣어주고, visited 까지 같이 잡아줌
        * */
        String[] count = expression.split("\\+|-|\\*");
        String[] arr = new String[count.length + ]

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*'){
                // 기호가 있다면 건너뛰어야 하고, 이 기준으로 나누고, 초기화 시킴
                list.add(String.valueOf(stringBuilder));
                list.add(String.valueOf(expression.charAt(i)));
                stringBuilder = new StringBuilder();
                continue;
            }
            stringBuilder.append(expression.charAt(i));
        }
        String[] operation = {"+", "-", "*"};
        for (int i = 0; i < operation.length; i++) {
            // + - * 순으로 넘겨봄
            DFS(operation[i], list);
        }

        return answer;
    }

    private void DFS(String firstOperation, List<String> list) {

        // 가장 먼저 나와야하는 operation
        for (int i = 1; i < list.size()-1; i+=2) {
            // 연산에 대해서만 비교함
            if(list.get(i)==firstOperation){
                // 처음에 해아하는 연산
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
