package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;

public class Array2 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int hIndx = 0;
        int answer = 0;
        /**
         * �̷��� ������ �� ������ �ʿ� ����
         * �ڱ⺸�� ū ���� ��ü ���̿��� �� �ش� ���� �ε��� �� ���� ��
         * ���� ���ظ� ����� �� �� 
         * hidex citations.length-i; �� ���� �� -> hidex �� �������� �ٽ� citations�� �迭���� �̺��� �� ū ���� ã�� 
         * */
        for (int i = 0; i < citations.length; i++) {
        	hIndx = citations.length-i;
        	// �ش� �� �������� �� �̻� �ο�� ���� �� 
        	if(citations[i] >= hIndx) {
        		// hIndx �� �̻� �ο�� ������ �ٽ� citations���� ã�� 
        		answer = Math.max(answer, hIndx);
        	}
		}
        
        
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
