package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackQueue3 {

    class Process{
        int idx;
        int num;

        public Process(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int findNum = priorities[location];

        Queue<Integer> queue = new LinkedList<>();

        //queue �� ���� ���
        for (int num : priorities){
            queue.add(num);
        }
        // stream �̾Ƴ���
//        int maxNum = Arrays.stream(priorities).max().getAsInt();

        // queue �� ��� ���� �̱� ������
        while (!queue.isEmpty()){
            for (int i = 0; i < priorities.length-1; i++) {
                for (int j = i; j < priorities.length; j++) {
                    int currentNum = queue.poll();
                    if(currentNum<priorities[j]){
                        // �迭�� ���� ������ ū�� ������
                        queue.add(currentNum);
                        break;
                    }
                }
            }
        }


        return answer;
    }
}
