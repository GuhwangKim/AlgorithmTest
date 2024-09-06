package CodingTest.src.study.greedy;

import java.util.Arrays;

public class Level3 {
//
//[[-20,-15], [-14,-5], [-18,-13], [-5,-3]]
//
//    -20   -15
//        -18     -13
//             -14     -5
//                     -5    -3

    public int solution(int[][] routes) {

        int answer = 1 ;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        // 2번쨰 숫자를 기준으로

        int standard = routes[0][1];

        for (int i = 1; i < routes.length-1; i++) {
            if (standard >= routes[i][0]) {
                continue;
            }
            standard = routes[i][1];
            answer++;
        }

        return answer;
    }

}
