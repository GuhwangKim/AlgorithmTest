package CodingTest.src.programmers_lv2;

public class Solution103 {
    int solution(int[][] land) {
        int answer = 0;
        /**
         * 경우의수 트리 만들면 되는 것 같은데
         *
         * 깊이는 4 DFS
         * total hard coding
         * 0 1 2 3
         * DP
         * */

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            // 1, 0 =?
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
            // last row keep adding
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer , land[land.length - 1][i]);
        }

        return answer;
    }

    private void DFS(int currentCol, int total) {
        for (int i = 0; i < ; i++) {
            
        }
    }
}
