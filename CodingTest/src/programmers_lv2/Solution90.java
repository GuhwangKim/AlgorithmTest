package CodingTest.src.programmers_lv2;

public class Solution90 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        // ���ϱⰡ ��� ����Ǵ� ���� ó������ ���ذ� �ȵ�
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
               int temp = 0; 
               //���� for ���� ���� �迭�� �°� ¥���� ��
               // �ջ� �ϴ� �κ��� ���� �� 
                for (int k = 0; k < arr2.length; k++) {
                    temp += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = temp;
            }
        }
        return answer;
    }
}
