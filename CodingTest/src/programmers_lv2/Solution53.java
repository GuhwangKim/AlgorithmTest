package CodingTest.src.programmers_lv2;

public class Solution53 {
	public int solution(int[] a) {
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        int leftmin = a[0];
        // ���� ���� ���� ��
        int rightmin = a[a.length-1];
        // ������ ���� ���� ��

        for (int i = 1; i <= a.length-1; i++) {
			if(leftmin>a[i]) {
				leftmin = a[i];
                // ���ʿ� ����ؼ� �ּ� ���� ������
			}
            leftMin[i] = leftmin;
		}

        for (int i = a.length-2; i > 0; i--) {
			// ������ ���� ������ �տ������� �ϳ��� ������
            if(rightmin>a[i]){
                rightmin = a[i];
            }
        	rightMin[i] = rightmin;
        	// ���� �ɷ� �� �տ� �ε����� ��

		}
        if(a.length == 1) { // ������ ������ 1���� ��
            return 1;
        }

        int answer = 2;
        for (int i = 1; i <= a.length-2 ; i++) {
            if(a[i]>leftMin[i] && a[i]>rightMin[i]){
                continue;  // ��Ŀ�� �������� ����
            }
            answer++;
        }
        return answer;
    }
}
