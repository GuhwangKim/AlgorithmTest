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
        	// 판매자 순대로 loop 
        	
            String sellersName = seller[i];
            // 현재 판매를 한 member
            int profit = 100*amount[i];

            while (!sellersName.equals("-")){ // 가장 상위에 갈 때까지 계속 
                int profitForParent = profit/10;
                // 부모에게 넘겨주는 금액 (순이익을 구하기 위한 계산값) 
                int nowProfit = profit - profitForParent;
                // 순수익

                answer[memberIndexMap.get(sellersName)] += nowProfit;
                // 판매자의 이름에 해당하는 idx를 찾아 거기에 수익을 더함

                sellersName = parentMap.get(sellersName);
                // 자식 값에 따른 부모 값으로 계속해서 갱신해줌 
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
