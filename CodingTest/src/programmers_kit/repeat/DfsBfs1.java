package CodingTest.src.programmers_kit.repeat;

public class DfsBfs1 {
    int cnt;
    public int solution(int[] numbers, int target) {
        BFS(numbers, target, 0, 0);

        return cnt;
    }

    private void BFS(int[] numbers, int target, int sum, int level) {
        if(level==numbers.length && sum==target){
            cnt++;

        }

        BFS(numbers, target, sum+numbers[level+1], level+1);
        BFS(numbers, target, sum-numbers[level+1], level+1);
    }
}
