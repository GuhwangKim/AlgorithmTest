package CodingTest.src.programmers_lv2;

/**
 * dijkstra
 * */
public class Solution84 {
    static int cnt;
    static int[][] arr;
    static int[] dist;
    static boolean[] visited;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        cnt = 0;
        arr = new int[N + 1][N + 1];
        // 인접행렬초기화
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                arr[i][j] = 500001;
            }
        }
        // 인접행렬 거리 값
        for (int i = 0; i < road.length; i++) {
            if(arr[road[i][0]][road[i][1]] > road[i][2]){

            }
        }


        return answer;
    }
}
