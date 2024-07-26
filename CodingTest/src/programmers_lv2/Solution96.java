package CodingTest.src.programmers_lv2;

public class Solution96 {
    static int total;
    public int[] solution(int n, long k) {
        int[] answer = {};
        total = n;
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[total];
            DFS(i, answer, visited);
        }

        return answer;
    }

    public void DFS(int ord, int[] answer, boolean[] visited) {
        if(visited[ord-1]){
            return;
        }
        visited[ord-1] = true;
        for (int i = 1; i <= total ; i++) {

        }
    }
}
