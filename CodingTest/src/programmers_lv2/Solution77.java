package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution77 {
    public int solution(int[] A, int[] B) {
        // A�� B�� ������
        Arrays.sort(A);
        Arrays.sort(B);

        int idx = 0;

        for (int i = 0; i < B.length; i++) {
            if(A[idx]>=B[i]){
                // A�� ���� �� ũ�� = B�� ���� ���̱� ������ �Ѿ
                // B�� �Ѿ���� A�� �������� ����
                continue;
            } else{
                // B�� �� ŭ => A�� �Բ� �Ѿ
                idx++;
            }
        }
        return idx; // ������ A�� ���°���� ����� �ߴ���
    }
}
