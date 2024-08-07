package CodingTest.src.programmers_lv2;

public class Solution98 {
    int givenNum = 0;
    int answer = 0;
    boolean numberOne = false;
    public int solution(int n) {

        return answer+1;
    }

    private void sum(int i) {
        int total = i;
        int idx = 1;

        while (total + (i-idx) <= givenNum) {
            if (i-idx == 1) {
                // 끝까지 왔다는 것
                numberOne = true;
            }
            // 합이 주어진 숫자보다 작을 때까지 더함
            total += (i-idx);
            System.out.println("total : "+total);
            if (total == givenNum) {
                // 연속된 합이 같을 때임
                answer++;
                return; // 루프 빠져서 다시 돌아감
            }
            idx++;
        }

    }
}
