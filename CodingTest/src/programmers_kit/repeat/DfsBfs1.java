package CodingTest.src.programmers_kit.repeat;

/**
 * 1. BFS 에 level을 하나씩 더해주고 
 * 2. 더해준 level을 배열의 index로 받을 것이기 때문에 for 문 loop가 필요 없음 
 * */

public class DfsBfs1 {
    int cnt;
    public int solution(int[] numbers, int target) {
        BFS(numbers, target, 0, 0);

        return cnt;
    }

    private void BFS(int[] numbers, int target, int sum, int level) {
        if(level==numbers.length){
        	if(sum==target)
            cnt++;
            return;

        }

        BFS(numbers, target, sum+numbers[level], level+1);
        BFS(numbers, target, sum-numbers[level], level+1);
    }
}
