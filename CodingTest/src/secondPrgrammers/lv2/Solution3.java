package CodingTest.src.secondPrgrammers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 광물캐기
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 * */
public class Solution3 {
    public int solution(int[] picks, String[] minerals) {
        // 광물은 순서대로만 
        // pick 을 순서대로 실행하는 방법 1번째 -> 2번째 부터 -> 3번째 
        // 1 2 3 , 1 3 2 , 2 1 3, 2 3 1, 3 1 2 , 3 2 1 총 6개의 가지수 (0까지)
        // 해당 경우에 따라 minerals를 순회하면서 합을 구하고 max와 비교 (minerals의 끝까지) 

        // pick 에서 숫자가 넘겨짐
        int answer = Integer.MAX_VALUE;
        String[] tools = new String[3];

        // 경우의 수를 넣은 배열 (총 6개)


        // 현재 피로도
        int currentTired = 0;

        for (int i = 0; i < picks.length; i++) {
            // bfs (3개까지 갔을 때 check function level,
            bfs(0, i, tools);

        }

        answer = Math.min(answer, currentTired);

        return answer;
    }

    private void bfs(int level, int index, String[] tools) {
        if (level > 3) {
            // 최종 단계까지 옴
            return;
        }
        Queue<Integer> queue = new LinkedList<>();

        queue.add(index);
        // 첫번쨰 인덱스를 담았음

        while (queue.isEmpty()) {
            String currentPicksPower = "";
            int currentIdx = queue.poll();

            if (index == 0) {
                currentPicksPower = "diamond";
            } else if (index == 1) {
                currentPicksPower = "iron";
            } else{
                currentPicksPower = "stone";
            }
            tools[level] = currentPicksPower;
        }
    }

    private int check (int currentPick, String currentPicksPower) {
        for (int i = 0; i < minerals.length; i++) {
            String mineral = minerals[i];
            while (currentPick > 0) {
                if (currentPicksPower.equals("diamond")) {
                    currentTired++; // 1만 추가

                } else if (currentPicksPower.equals("iron")) {
                    if (mineral.equals("diamond")) {
                        currentTired += 5;
                    }else{
                        currentTired++;
                    }
                }else{
                    if (mineral.equals("diamond")) {
                        currentTired += 25;
                    } else if (mineral.equals("iron")) {
                        currentTired += 5;
                    }else{
                        currentTired++;
                    }
                }
            }
            currentPick--;
        }
    }
    
}
