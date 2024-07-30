package CodingTest.src.programmers_lv2;

public class Solution96 {
    static int cnt;
    boolean[] visited;
    int[] answer;
    public int[] solution(int n, long k) {
        answer = new int[n];
        int[] temp = new int[n];
        visited = new boolean[n]; // 방문한 배열은 전역으로 설정
        DFS(0,temp, k);
        return answer;
    }

    public void DFS(int ord, int[] temp, long k) {
        if(ord == temp.length){
            // 가장 마지막 깊이까지 옴
            cnt++; // 조건에 만족하는 배열의 개수 더해주기
            if (cnt == k) {
                // 해당하는 순서라면
                for (int i = 0; i < temp.length; i++) {
                    answer[i] = temp[i];
                }
            }
            return;
        }
        for (int i = 0; i < temp.length ; i++) {
            if (!visited[i]) {
                // 방문하지 않았다면
                visited[i] = true;
                temp[ord] = i+1;// 깊이 대로 값이 바뀌어 넣어짐
                DFS(ord + 1, temp, k);
                visited[i] = false;

            }
        }
    }
}
