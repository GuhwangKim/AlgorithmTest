package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;

public class Greedy4 {
    int[] parent;
    public int solution(int n, int[][] costs) {
        /**
         * costs를 비용을 기준으로 정렬
         * 가장 끝까지의 노드를 구해야함
         *
         * */

        int totalCost = 0;

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        // 오름차순으로 정렬

        parent = new int[n];
        // 가장 끝 노드의 값을 담음

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int startNum = 0;
        for (int[] cost : costs) {
            startNum = cost[0];
            int endNum = cost[1];
            int price = cost[2];
        }

        int startNumsParent = findParentNum(startNum);



        return totalCost;
    }

    private int findParentNum(int startNum) {
        if(parent[startNum] == startNum){
            // 자기 자신인 경우 가장 마지막
            return startNum;
        } else{
            return parent[startNum] = findParentNum(parent[startNum]);
            // 계속해서 더 끝까지 감
        }

    }
}
