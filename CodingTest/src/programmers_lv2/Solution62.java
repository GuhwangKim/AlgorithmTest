package CodingTest.src.programmers_lv2;

public class Solution62 {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        /**
         * key에 원소 값 - lock의 원소 값이 일치 하지 않는다면 => 끝
         * lock값이 막힌 부분에 있어서는 상하 좌우 이동을 할 수 있음
         * lock의 행이 모두다 1이라면 아래 이동 가능
         *        열이 모두다 1이라면 왼쪽 오른쪽 이동 가능
         * key를 회전해봄 - 다시 lock 과 비교해봄
         * */

        int kLength = key.length;
        int lLength = lock.length;

        int extLen = lLength + (kLength)*2 -2;
        int[][] extArr = new int[extLen][extLen]; // 확장 배열

        // 확장 배열에 lock 표시
        for (int i = kLength-1; i < kLength+lLength-1; i++) {
            for (int j = kLength-1; j < kLength+lLength-1; j++) {
                extArr[i][j] = lock[i-(kLength-1)][i-(kLength-1)];
            }
        }

        // 회전하면서 4번 조회함
        for (int i = 0; i < 4; i++) {
            if(check(extArr, key, lLength)){
                return true;
            }
            rotate(key);
        }

        return answer;
    }
}
