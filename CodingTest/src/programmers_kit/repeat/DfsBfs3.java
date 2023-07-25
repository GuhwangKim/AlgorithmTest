package CodingTest.src.programmers_kit.repeat;

public class DfsBfs3 {
    int[] dx ={-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean visited[][];
    int answer = 0;
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        /**
         * 0 0 에 있음
         * 좌표의 위치를 보냄
         * 적의 위치와 같다면 그때 level을 반환하고, math적용
         * idx map.length -1, maps[0].length -1 까지 가면 상대의 말을 잡음
         * */

        DFS(0, 0, maps, 0);

        return 0;
    }

    private void DFS(int positionX, int positionY, int[][] maps, int cnt) {
        if(positionX== maps.length && positionY==maps[0].length){
            // 좌표가 끝까지 도달 했을 때
            answer = Math.min(cnt, answer);
            return;
        }



    }
}
