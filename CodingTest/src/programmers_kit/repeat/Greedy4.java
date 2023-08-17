package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;

public class Greedy4 {
    int[] parent;
    public int solution(int n, int[][] costs) {
        /**
         * costs�� ����� �������� ����
         * ���� �������� ��带 ���ؾ���
         *
         * */

        int totalCost = 0;

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        // ������������ ����

        parent = new int[n];
        // ���� �� ����� ���� ����

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
            // �ڱ� �ڽ��� ��� ���� ������
            return startNum;
        } else{
            return parent[startNum] = findParentNum(parent[startNum]);
            // ����ؼ� �� ������ ��
        }

    }
}
