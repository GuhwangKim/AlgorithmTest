package CodingTest.src.programmers_lv2;

public class Solution65 {
    public int solution(String dirs) {
        int answer = 0;

        /**
         * 방문을 했나 안했나 플래그 처리를 해야함
         * 같은 좌표를 오게 되면 세지 않음
         *  */

        boolean[][] visited = new boolean[10][10];

        int curXidx = 0;
        int curYidx = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char currAlpha = dirs.charAt(i);
            if(currAlpha =='U'){
                // 위
                int nextXidx = curXidx;
                int nextYidx = curYidx + 1;

                if(nextXidx)

            } else if (currAlpha == 'D') {
                // 아래

            } else if (currAlpha == 'L') {
                // 왼쪽

            } else{
                // 오른쪽
            }
        }

        return answer;
    }
}
