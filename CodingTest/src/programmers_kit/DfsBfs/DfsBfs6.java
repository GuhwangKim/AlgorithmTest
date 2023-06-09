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
         * 1. arr[i][j]가 1인 경우 -> 그 반대도 1이 되*/

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int startNum = 0; startNum < n; startNum++) {
            for (int endNum = startNum+1; endNum < n; endNum++) {
                // 1. 반으로 잘라서 윗 부분만 검증
               if(computers[startNum][endNum]==1){
                   // 서로 연결된 경우 -> 하위 j의 상위
                   int startNumsParent = findParentNum(startNum);
                   int endsNumParent = findParentNum(endNum);
                   if(endsNumParent==startNumsParent){
                       System.out.println(endsNumParent);
                       continue;
                       // 두개의 부모가 같다면
                   } else{
                       // 두개의 부모가 다르다면 현재  두 노드는 연결된 산태이므로
                       // 하위의 부모 값을 상위로 변경
                       parent[endsNumParent]=startNum;
                       System.out.println(startNum);

                   }
               }
            }
        }
        // parent 배열에 있는 값의 중복을 제외한 값을 구함
        answer = (int)Arrays.stream(parent).distinct().count();
        return answer;
    }

    private int findParentNum(int nodeNum) {
        if(parent[nodeNum]==nodeNum){
            return nodeNum;
        } else{
            return parent[nodeNum] = findParentNum(parent[nodeNum]);
            // 계속해서 위로 따라 올라가는 로직
            // 위로 올라가다가
        }
    }
}
