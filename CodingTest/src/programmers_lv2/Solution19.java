package CodingTest.src.programmers_lv2;

public class Solution19 {
    int answer = 0;
    public int solution(int x, int y, int n) {
        /**
         * 1. x에 n을 더하는 경우
         * 2. x에 2또는 3을 곱하는 경우
         * */
        DFS(x, y, n, x, 0);


        return answer;
    }

    private void DFS(int x, int y, int n, int presentNum, int cnt) {

        if(x==n){
            answer = Math.min(answer, cnt);
            return;
            // 같다면 바로
        }
        // 그냥 무작정 검증하다보면 정말 끝도
        if(x<y){
            DFS(x, y, n, presentNum*3, cnt+1);
            DFS(x, y, n, presentNum*2, cnt+1);
            DFS(x, y, n, presentNum+n, cnt+1);
            // 이렇게 되면 섞이는 경우를 반영할 수 없음


        }



    }
}
