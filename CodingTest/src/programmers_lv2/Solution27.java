package CodingTest.src.programmers_lv2;

public class Solution27 {
    public long solution(int k, int d) {
        long answer = 0;

        /**
         * 0, 0 에서 시작함
         * 1부터 시작을 해서 총 d까지 검증을 하고
         * k 만큼 값이 증가됨
         * 그때 x y  값에 루트를 씌운 값이 d보다 같거나 작으면 cnt 추가됨
         *
         * */

        for (int i = 0; i <= d; i++) { //x에서 시작 0 1*k 2*k 3*k ....d
            int idxX= i*=k;
            if(idxX>d){
                break;
            }
            // i 값에 k를 곱함
            for (int j = idxX; j <=d ; j++) { // x값일 때 y 값
                int idxY = j*=k;
                // j 씩 증가함
                if(idxY>d){
                    // 곱한 값이 y 좌표 넘어가면 빠져나옴
                    break;
                }

            }

        }

        return answer;
    }
}
