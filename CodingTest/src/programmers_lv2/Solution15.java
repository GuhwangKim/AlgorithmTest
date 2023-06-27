package CodingTest.src.programmers_lv2;

public class Solution15 {

        /**
         * 1. 승자가 없는 경우 o가 x 보다 2개 이상 많으면 안됨, x는 o보다 1개 이상 많으면 안됨
         * 2. o가 승리하는 경우 : o 는 x보다 1개 더 많음
         * 3. x가 승리하는 경우 : x 의 개수 = o의 개수
         * 4. o x 모두 승리하는 경우 없음 (개수가 서로 3개)
         * */
    public int solution(String[] board) {
        int answer = -1;

        int countO = 0;
        int countX = 0;

        int oWin = 0;
        int xWing = 0;


        // 개수를 세줌
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i].charAt(j)=='O'){
                    countO++;
                }if(board[i].charAt(j)=='X'){
                    countX++;
                }
            }
        }

        // 개수로 검증 우선
        if(countO-countX>1 || countX>countO){
            return 0;
        }
        // 0가 이기는 경우
        if(countO>=3){

        }



        return answer;
    }
}
