package CodingTest.src.programmers_kit.repeat;

/**
 * 1. BFS �� level�� �ϳ��� �����ְ� 
 * 2. ������ level�� �迭�� index�� ���� ���̱� ������ for �� loop�� �ʿ� ���� 
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
