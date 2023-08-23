package CodingTest.src.programmers_lv2;

import java.util.LinkedList;
import java.util.List;

public class Solution35 {
    boolean[] checked;
    int answer = 1;
    public int solution(int[] cards){
        checked = new boolean[cards.length];

        for(int card : cards){
            calulate(card-1, cards);
        }
        return answer;
    }

    private void calulate(int startIdx, int[] cards) {

        // �� �Ʒ��� ������ �Լ�ȭ
        for (int i = 0; i < cards.length; i++) {
            int boxCnt = 0;
            while(!checked[i]){ // �湮 ���� ��츸 �Ʒ� ���� Ž
                boxCnt++;
                int openedBoxIdx = cards[i]-1;
                i = openedBoxIdx;
                checked[openedBoxIdx] = true;
                // ���
            }
            if(boxCnt==cards.length){
                // �� ��� ���
                answer = 0;
                return;
            }
            if(boxCnt>0){
                // �ϳ��� ��� ��� �����Ѵٸ�
                answer*=boxCnt;
            }
        }
    }
}
