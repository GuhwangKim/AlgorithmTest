package CodingTest.src.programmers_lv2;

import java.util.Stack;

public class Solution95 {
    public int[] solution(int n, int s) {
        int[] answer = {};
        int max = -1;
        // 예를 들면 n = 3
        // 합이 s

        if (n < s) {
            // 자연수의 개수가 더해지는 합보다 작은 경우 => 조건 부합 x
            answer[0] = -1;
            return answer;
        }

        // 2자리, 3자리, 4자리... 이런식으로 더할 수 있는 경우로 나눠야하나
        Stack<Integer> stack = new Stack<>();
        stack.push(s);

        // stack 에 있는 숫자들의 곱을 구해야하는데 어떻게 ?

        while (true) {

            int temp = stack.pop();
            if (temp != 1) {
                stack.push(temp - 1);
                stack.push(1);
                // 위와 아래의 합은 s
                // 스택을 복사해보자
                Stack<Integer> stack2 = new Stack<>(sta
            }else {
                int sum = 2;
                for (; !stack.isEmpty()&&stack.peek()==1; stack.pop()) {
                    // 1이 아닌 수가 나올 때까지 계속 꺼내면서
                    // 꺼내는 수들의 합 +1 을 sum에 저장
                    sum++;
                }
                if (stack.isEmpty()) {
                    break;
                }
                int pivot = stack.pop() - 1;
                stack.push(pivot);
                while (sum > pivot) {
                    stack.push(pivot);
                    sum -= pivot;
                }
                stack.push(sum);
            }
        }


        return answer;
    }
}
