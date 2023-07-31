package CodingTest.src.programmers_lv2;

public class Solution26 {
    /**
     * n <enemy[i] 일 떄 i 단계까지 가능함
     * k 만큼은 보장함
     * 나머지 값을 어떻게 조합할 것인지가 중욯마
     *
     * 1) enemy의 길이 <= k 라면 enemy의 길이를 리턴
     * 2) n <enemy[i] 일 떄 i 단계까지 가능함
     * 3) 그렇지 않다면
     *      - n-=enemy[i]
     *
     *      - K>0 라면 k-1 쓰고 i 한단계 띄어넘음
     * */


    int answer = 0;
    public int solution(int n, int k, int[] enemy) {
        int sum = 0;
        for(int num : enemy){
            sum+=num;
        }
        if(k>= enemy.length || n>=sum){
            // 1. 무적권 > 적 / 병사수 > 적의 수
            return enemy.length;
        }
        BFS(n,k, enemy, 0);

        return answer+1;
    }

    private void BFS(int n, int k, int[] enemy, int level) {

        for (int i = level; i < enemy.length; i++) {
            if(k>0){
                // 한번 건너 뛰는 경우
               BFS(n, k-1, enemy, level+1);
            } else if (n-enemy[i]>0) {
                // 적 빼는 경우
                BFS(n-enemy[i], k, enemy, level+1);
            }
            answer = Math.max(answer, level);
            // 루프를 끝내야함
            break;

        }

    }

}
