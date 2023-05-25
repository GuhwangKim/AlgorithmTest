package CodingTest.src.programmers_kit.StackQueue;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

public class StackQueue4 {
    @RequiredArgsConstructor
    class EachTrucks{
        int weight;
        int currentidx;

        @Builder
        public EachTrucks(int weight, int currentidx){
            this.weight = weight;
            this.currentidx = currentidx;
        }
    }


    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currentIndex = 0;
        Queue<EachTrucks> queue = new LinkedList<>();

        while (!queue.isEmpty()){
            int totalTime = 0;
            int currentBridgeWeight = 0;
            for (int i = 0; i < truck_weights.length; i++) {
                if(queue.peek().currentidx==bridge_length){
                    // 트럭이 다 왔으면 우선 하나 뽑아줌
                    currentBridgeWeight-=queue.poll().weight;
                    // 현재 트럭의 무게에 뽑는 트럭의 무게를 빼주고 하나 제거함
                }

                if(currentBridgeWeight>weight){
                    // 현재 다리 위에 트럭들의 무게가 허용치를 넘기는 경우에 계산 안하고 건너뜀
                    continue;
                }
                queue.add(new EachTrucks(truck_weights[i], currentIndex+1));
                // 트럭의 무게와 현재 인덱스가 담긴 객체를 집어넣음
                currentBridgeWeight+=truck_weights[i];
                // 현재 다리 위에 있는 자동차의 무게

                // 한번 루프 돌때마다 시간 추가
                answer++;
            }
        }
        return answer;
    }
}
