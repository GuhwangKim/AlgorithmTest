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

        // 이 아래의 로직을 함수화
        for (int i = 0; i < cards.length; i++) {
            int boxCnt = 0;
            while(!checked[i]){ // 방문 안한 경우만 아래 문을 탐
                boxCnt++;
                int openedBoxIdx = cards[i]-1;
                i = openedBoxIdx;
                checked[openedBoxIdx] = true;
                // 열어봄
            }
            if(boxCnt==cards.length){
                // 다 열어본 경우
                answer = 0;
                return;
            }
            if(boxCnt>0){
                // 하나라도 열어본 경우 존재한다면
                answer*=boxCnt;
            }
        }
    }
}
