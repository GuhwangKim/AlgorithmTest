package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;

public class Binary1 {
    public long solution(int n, int[] times) {
    /**
     * 1. �ִ� �ּ� ���� �߰� ���� ����
     * 2. �߰���/�ҿ�ð� = ó�������� ����� �� ***
     * 3. *** �ִ� = �ּ� ���� ���� ������ �ּ� �ִ� ���� ���̰� ���ϴ� �۾��� �ݺ�
     * */
        Arrays.sort(times);
        long totalTime = 0;

        long maxTime = times[times.length-1]*n;
        long minTime = 0;
        // ������ ���� ���ϴ� ����̶� = 1����� �ɸ��� �ð����� ����

        while(minTime<=maxTime){
            int sumPeople = 0;
            long mid = (maxTime+minTime)/2; // 30
            for (int i = 0; i < times.length; i++) {
                sumPeople+=mid/times[i]; // �߰� �� / �ҿ�ð�  = ó���� �� �ִ� ����� ��
            }

            if(sumPeople>=n){
                // �ð��� �ٿ��� ��
                totalTime = mid;
                maxTime = mid-1;

            } else{
                // �ð��� ���ڸ� �ð��� �÷�����
                minTime = mid+1;
            }
        }
        return totalTime;
    }
}
