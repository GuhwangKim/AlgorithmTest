package CodingTest.src.study.greedy;

import java.util.Arrays;

public class Level2_1 {
    /**
     * 1) 최소의 구명 보트 = 최대로 많이 담아야 하므로,
     * 우선은 배열을 오름차순으로 정렬
     * 2) 최대 2인만 가능하므로
     * 몸무게 최대값보다 무게제한은 항상 큼
     * 앞 뒤로 비교해서 값을 더해서 그 값이 무게제한 보다 작으면 두개를 같이
     * */
    public int solution(int[] people, int limit) {
        int answer = 0;
        if (people.length == 1) {
            return 1;
        }

        Arrays.sort(people); // 오름차순
        int startIdx = 0;
        int endIdx = people.length-1;

        for (int i = endIdx; i >= startIdx; i--) {
            if (people[i] + people[startIdx] <= limit) {
                // 2명 함께
                startIdx++;
            }
            answer++;
        }

        return answer;
    }
}
