package CodingTest.src.programmers_lv2;

import java.util.HashMap;
import java.util.Map;

public class Solution44 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, String> parentMap = new HashMap<>();
        // �ڽİ��� ���� �θ� ���� ���� [key �ڽ� : value �θ�]
        Map<String, Integer> memberIndexMap = new HashMap<>();
        // member �� ���� idx �� ���� [key �̸� : value idx]

        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            memberIndexMap.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            String now = seller[i];
            // ���� �ǸŸ� �� member
            int profit = 100*amount[i];

            while (!now.equals("-")){
                int profitForParent = profit/10;
                // �θ𿡰� �Ѱ��ִ� �ݾ�
                int nowProfit = profit - profitForParent;
                // ������

                answer[memberIndexMap.get(now)] += nowProfit;
                // �Ǹ����� �̸��� �ش��ϴ� idx�� ã�� �ű⿡ ������ ����

                now = parentMap.get(now);
                // �ڽ� ���� ���� �θ� ��
                profit /=10;
                // �θ����״� 10���� ���� ������ (����)

                if(profit<1){
                    break;

                }


            }

        }

        return answer;
    }
}
