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
                // 연산자라면
                list.add(expression.substring(start, i));
                // 연산자 앞에 숫자를 집어넣음
                list.add(expression.charAt(i)+"");
                // 연산자를 집어넣음
                start = i+1;
                // 시작 포인트를 연산자 그 다음으로 함
            }
        }
        list.add(expression.substring(start));

        for (int i = 0; i < op.length; i++) {
            // 연산자의 조합 개수
            ArrayList<String> subList = new ArrayList<>(list);
            for (int j = 0; j < 3; j++) {
                // 연산자의 개수 3개
                for (int k = 0; k < subList.size(); k++) {
                    if(op[i][j].equals(subList.get(k))){
                        // 나온 숫자가 연산자일 때
                        subList.set(k-1, cal(subList.get(k-1),subList.get(k), subList.get(k+1)));
                        // k -1 숫자 k 연산자 k+1 숫자를 넘겨서 계산한 후 , k-1 위치에 저장
                        subList.remove(k);
                        // k번쨰를 삭제
                        subList.remove(k);
                        // 2개를 연산했으므로, 숫자 2개를 제외시킴
                        k--;
                    }
                }
            }
            // 연산자 조합의 개수 로 나온 값을 비교함
            // 계산 후엔 값이 하나만 남음
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
