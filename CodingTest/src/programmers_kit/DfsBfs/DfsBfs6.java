package CodingTest.src.programmers_kit.DfsBfs;

public class DfsBfs6 {
    int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        /**
         * 1. arr[i][j]�� 1�� ��� -> �� �ݴ뵵 1�� ��*/

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int startNum = 0; startNum < n; startNum++) {
            for (int endNum = 0; endNum < n; endNum++) {
               if(computers[startNum][endNum]==1){
                   // ���� ����� ��� -> ���� j�� ����
                   int startNumsParent = findParentNum(startNum);
                   int endsNumParent = findParentNum(endNum);
                   if(endsNumParent==startNumsParent){
                       // �ΰ��� �θ� ���ٸ�
                   } else{
                       // �ΰ��� �θ� �ٸ��ٸ� ������ �θ� ���� ������ ����
                       parent[endsNumParent]=startNum;
                   }
               }
            }
        }
        return answer;
    }

    private int findParentNum(int nodeNum) {
        if(parent[nodeNum]==nodeNum){
            return nodeNum;
        } else{
            return parent[nodeNum] =
        }
        return 1;
    }
}
