package CodingTest.src.programmers_kit.DfsBfs;

import java.util.Arrays;

public class DfsBfs6 {
    int[] parent;

    public static void main(String[] args) {
        DfsBfs6 ex = new DfsBfs6();
        int[][] comp = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        ex.solution(3, comp);

    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        /**
         * 1. arr[i][j]�� 1�� ��� -> �� �ݴ뵵 1�� ��*/

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int startNum = 0; startNum < n; startNum++) {
            for (int endNum = startNum+1; endNum < n; endNum++) {
                // 1. ������ �߶� �� �κи� ����
               if(computers[startNum][endNum]==1){
                   // ���� ����� ��� -> ���� j�� ����
                   int startNumsParent = findParentNum(startNum);
                   int endsNumParent = findParentNum(endNum);
                   if(endsNumParent==startNumsParent){
                       System.out.println(endsNumParent);
                       continue;
                       // �ΰ��� �θ� ���ٸ�
                   } else{
                       // �ΰ��� �θ� �ٸ��ٸ� ����  �� ���� ����� �����̹Ƿ�
                       // ������ �θ� ���� ������ ����
                       parent[endsNumParent]=startNum;
                       System.out.println(startNum);

                   }
               }
            }
        }
        // parent �迭�� �ִ� ���� �ߺ��� ������ ���� ����
        answer = (int)Arrays.stream(parent).distinct().count();
        return answer;
    }

    private int findParentNum(int nodeNum) {
        if(parent[nodeNum]==nodeNum){
            return nodeNum;
        } else{
            return parent[nodeNum] = findParentNum(parent[nodeNum]);
            // ����ؼ� ���� ���� �ö󰡴� ����
            // ���� �ö󰡴ٰ�
        }
    }
}
