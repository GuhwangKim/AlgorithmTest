package CodingTest.src.programmers_lv2;

public class Solution90 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        // 곱하기가 어떻게 연산되는 건지 처음부터 이해가 안됨
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
               int temp = 0; 
               //위에 for 문은 정답 배열에 맞게 짜여진 것
               // 합산 하는 부분은 따로 또 
                for (int k = 0; k < arr2.length; k++) {
                    temp += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = temp;
            }
        }
        return answer;
    }
}
