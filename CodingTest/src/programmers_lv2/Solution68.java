package CodingTest.src.programmers_lv2;

public class Solution68 {
    int answer = Integer.MIN_VALUE;
    public int solution(int[][] triangle) {
        int level = 0;
        int sum = 0;

        for (int j = 0; j < triangle.length; j++){
            // �迭�� ������ �Ѱ��� ��������
            for (int i = 0; i < triangle[j].length; i++) {
                // ���� �迭�� ���� ����
                sum+=triangle[j][i];
                DFS(i, triangle, level+1, sum);
                sum-=triangle[j][i];
            }
        }
        return answer;
    }

    private void DFS(int curIdx, int[][] triangle, int level, int sum) {
        if(level>= triangle.length){
            // ������ �Ʒ����� �� ��
            answer = Math.max(answer, sum);
            return;
        }

        // �� ���� ��
        int[] nextRow = triangle[level];

        for (int i = curIdx; i < 2; i++) {
            // �� �����࿡�� �Ѿ�� �ε���~ ���� ������
            sum+=nextRow[i];
            DFS(i, triangle, level+1, sum);
            sum-=nextRow[i];
        }


    }
}
