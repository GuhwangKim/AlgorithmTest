package CodingTest.src.programmers_lv2;

public class Solution68 {
    int answer = Integer.MIN_VALUE;
    public int solution(int[][] triangle) {
        int level = 0;
        int sum = 0;

        for (int j = 0; j < triangle.length; j++){
            // 배열의 위부터 한개씩 빠져나옴
            for (int i = 0; i < triangle[j].length; i++) {
                // 현재 배열의 글자 번쨰
                sum+=triangle[j][i];
                DFS(i, triangle, level+1, sum);
                sum-=triangle[j][i];
            }
        }
        return answer;
    }

    private void DFS(int curIdx, int[][] triangle, int level, int sum) {
        if(level>= triangle.length){
            // 마지막 아래까지 온 것
            answer = Math.max(answer, sum);
            return;
        }

        // 그 다음 행
        int[] nextRow = triangle[level];

        for (int i = curIdx; i < 2; i++) {
            // 그 다음행에서 넘어온 인덱스~ 왼쪽 오른쪽
            sum+=nextRow[i];
            DFS(i, triangle, level+1, sum);
            sum-=nextRow[i];
        }


    }
}
