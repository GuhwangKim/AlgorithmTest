package CodingTest.src.programmers_kit.Greedy;

public class Greedy3 {
    static int totalWeight;
    static int cnt = 0;
    static int currentCnt = 0;
    static boolean[] visited;
    static int answer = 0;
    public int solution(int[] people, int limit) {
        visited = new boolean[people.length];

        /*
        1. 몸무게 하나씩 더함
        2. limit 초과인 경우 그때 돌아옴
        3. 트리 하나를 위로 올라갔을 때의 min을 정답으로 담음
        몸무게가 초과한 경우 하나를
        몸무가게 초과하지 않은 경우cnt를 더해주지 않고
        어떠헥?
        */

        BFS(totalWeight, people, limit, cnt);

        return answer;
    }

    private void BFS(int totalWeight, int[] people, int limit, int cnt) {

        for (int i = 0; i < people.length; i++) {
            if(totalWeight > limit){
                // 1. 현재 총 무게가 리밋을 초과한 경우 리턴
                return;
            }
            if(!visited[i]){
                // 2. 방문하지 않은 경우
                visited[i]=true;
                // 3. 방문했다고 표시
                BFS(totalWeight+people[i], people, limit, cnt+1);
                visited[i]=false;
                // 4. 다시 돌아왔으면 풀어줌
            }

        }
        currentCnt+=cnt;
        // 5. 최상위 부모 루프 끝난 후에 다음 숫자가 최상위 부모가 될떄
        // 그때의 cnt 개수를 추가해주고
        // 가장 작은 것과 비교해줘야함
        totalWeight = 0;
        answer = Math.max(answer, cnt);
    }
}
