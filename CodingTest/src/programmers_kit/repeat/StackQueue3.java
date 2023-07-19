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

        //queue 에 값을 담기
        for (int num : priorities){
            queue.add(num);
        }
        // stream 뽑아내기
//        int maxNum = Arrays.stream(priorities).max().getAsInt();

        // queue 에 담긴 값을 뽑기 시작함
        while (!queue.isEmpty()){
            for (int i = 0; i < priorities.length-1; i++) {
                for (int j = i; j < priorities.length; j++) {
                    int currentNum = queue.poll();
                    if(currentNum<priorities[j]){
                        // 배열에 현재 값보다 큰게 있으면
                        queue.add(currentNum);
                        break;
                    }
                }
            }
        }


        return answer;
    }
}
