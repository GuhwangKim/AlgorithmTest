package CodingTest.src.programmers_lv2;

import java.util.Stack;

public class Solution95 {
    public int[] solution(int n, int s) {
        int[] answer = {};
        int max = -1;
        // ���� ��� n = 3
        // ���� s

        if (n < s) {
            // �ڿ����� ������ �������� �պ��� ���� ��� => ���� ���� x
            answer[0] = -1;
            return answer;
        }

        // 2�ڸ�, 3�ڸ�, 4�ڸ�... �̷������� ���� �� �ִ� ���� �������ϳ�
        Stack<Integer> stack = new Stack<>();
        stack.push(s);

        // stack �� �ִ� ���ڵ��� ���� ���ؾ��ϴµ� ��� ?

        while (true) {

            int temp = stack.pop();
            if (temp != 1) {
                stack.push(temp - 1);
                stack.push(1);
                // ���� �Ʒ��� ���� s
                // ������ �����غ���
                Stack<Integer> stack2 = new Stack<>(sta
            }else {
                int sum = 2;
                for (; !stack.isEmpty()&&stack.peek()==1; stack.pop()) {
                    // 1�� �ƴ� ���� ���� ������ ��� �����鼭
                    // ������ ������ �� +1 �� sum�� ����
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
