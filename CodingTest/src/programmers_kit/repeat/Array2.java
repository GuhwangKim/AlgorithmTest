package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;

public class Array2 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int hIndx = 0;
        int answer = 0;
        // ���� ���� �ʹ� �۾Ƽ� �ִ� ���� �ƴ�
        // �ڱ� ���� ū ���� �ڱ� �������� ���ƾ� ��
        // �ڿ� ���� �ʹ� Ŀ�� �����ϴ� ���� ����


        /**
         * �̷��� ������ �� ������ �ʿ� ����
         * �ڱ⺸�� ū ���� ��ü ���̿��� �� �ش� ���� �ε��� �� ���� ��
         * */
//        for (int i = 0; i < citations.length; i++) {
//            int cnt = 0;
//            for (int j = i; j < citations.length; j++) {
//                if(citations[i]<=citations[j]){
//                    cnt++;
//                }
//            }
//            if(cnt>=citations[i]){
//                hIndx = citations[i];
//                answer = Math.max(answer, hIndx);
//            }
//        }

        return answer;
    }
}
