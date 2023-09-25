package CodingTest.src.programmers_lv2;

import java.util.HashMap;
import java.util.Map;

public class Solution44 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, String> parentMap = new HashMap<>();
        // 자식값에 따른 부모 값을 저장 [key 자식 : value 부모]
        Map<String, Integer> memberIndexMap = new HashMap<>();
        // member 에 대한 idx 를 저장 [key 이름 : value idx]

        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            memberIndexMap.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            String now = seller[i];
            // 현재 판매를 한 member
            int profit = 100*amount[i];

            while (!now.equals("-")){
                int profitForParent = profit/10;
                // 부모에게 넘겨주는 금액
                int nowProfit = profit - profitForParent;
                // 순수익

                answer[memberIndexMap.get(now)] += nowProfit;
                // 판매자의 이름에 해당하는 idx를 찾아 거기에 수익을 더함

                now = parentMap.get(now);
                // 자식 값에 따른 부모 값
                profit /=10;
                // 부모한테는 10나눈 값을 전해줌 (쌓임)

                if(profit<1){
                    break;

                }


            }

        }

        return answer;
    }
}
