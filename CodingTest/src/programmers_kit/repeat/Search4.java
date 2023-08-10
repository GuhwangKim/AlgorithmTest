package CodingTest.src.programmers_kit.repeat;

import java.util.LinkedList;
import java.util.Queue;

public class Search4 {
    static int arr[][];
    public int solution(int n, int[][] wires) {
        /**
         * wires의 길이는 쥴의 길이
         * N은 노드의 개수
         * */
        int answer = 0;

        arr = new int[n+1][n+1];

        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
            //배열의 앞 뒤 값을 둘다 표시해줌,
        }

        for (int i = 0; i < wires.length; i++) {
            int frontNum = wires[i][0];
            int backNum = wires[i][1];

            arr[frontNum][backNum] = 0;
            arr[backNum][frontNum] = 0;
            // 연결 해제

            answer = Math.min(answer, BFS(frontNum, n));


        }

        return 0;
    }

    private int BFS(int frontNum, int nodeCnt) {
        boolean[] visited = new boolean[nodeCnt+1];
        int cnt  = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(frontNum);
        // 앞굴자


    }
}
