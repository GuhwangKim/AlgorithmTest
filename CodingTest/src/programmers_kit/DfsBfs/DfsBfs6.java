package CodingTest.src.programmers_kit.DfsBfs;

public class DfsBfs6 {
    int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        /**
         * 1. arr[i][j]가 1인 경우 -> 그 반대도 1이 되*/

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int startNum = 0; startNum < n; startNum++) {
            for (int endNum = 0; endNum < n; endNum++) {
               if(computers[startNum][endNum]==1){
                   // 서로 연결된 경우 -> 하위 j의 상위
                   int startNumsParent = findParentNum(startNum);
                   int endsNumParent = findParentNum(endNum);
                   if(endsNumParent==startNumsParent){
                       // 두개의 부모가 같다면
                   } else{
                       // 두개의 부모가 다르다면 하위의 부모 값을 상위로 변경
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
