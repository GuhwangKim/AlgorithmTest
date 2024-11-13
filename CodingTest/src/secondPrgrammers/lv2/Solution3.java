package CodingTest.src.secondPrgrammers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 광물캐기
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 * */
public class Solution3 {
    class MineralsTired {
        int d_cost;
        int i_cost;
        int s_cost;

        public MineralsTired(int d_cost, int i_cost, int s_cost) {
            this.d_cost = d_cost;
            this.i_cost = i_cost;
            this.s_cost = s_cost;
        }
    }
    public int solution(int[] picks, String[] minerals) {

        List<MineralsTired> stress = new ArrayList<>();

        int pick_cnt = Arrays.stream(picks).sum(); // 모든 곡괭이 수
        int work_cnt = Math.min(pick_cnt * 5, minerals.length); // 최대 작업량 (피로도는 별개임, 캘 수 있는 광물의 수)

        for (int i = 0; i < work_cnt; i++) {
            // 최대 작업량을 기준으로
            int d_cost = 0;
            int i_cost = 0;
            int s_cost = 0;

            // 최대 작업량 한 곡괭이당 5개
            for (int j = 0; j < 5; j++) {
                // ** 곡괭이 + 현재 미네랄
                int next = i + j;
                if (next == work_cnt) {
                    break;
                }
                // 어떤 곡괭이가 나오든 간에 미네랄 별 소모도
                switch (minerals[next]) {
                    case "diamond":
                        d_cost += 1;
                        i_cost += 5;
                        s_cost += 25;
                    case "iron": {
                        d_cost+=1;
                        i_cost+=1;
                        s_cost+=5;
                        break;
                    }
                    case "stone": {
                        d_cost+=1;
                        i_cost+=1;
                        s_cost+=1;
                        break;
                    }
                }
            }
            stress.add(new MineralsTired(d_cost, i_cost, s_cost));
        }

        Collections.sort(stress, (o1, o2) -> o2.s_cost - o2.s_cost);
        // 비용 많이 드는 묶음 순으로 정렬

        int min_cost = 0;
        for (int i = 0; i < stress.size(); i++) {
            if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
                break; // 어떤 곡괭이도 없음
            }

            if (picks[0] > 0) {
                // 다이아 있음
                picks[0]--;
                min_cost += stress.get(i).d_cost;
            } else if (picks[1] > 0) {
                picks[1] --;
                min_cost += stress.get(i).i_cost;
            } else if (picks[2] > 0) {
                picks[2]--;
                min_cost += stress.get(i).s_cost;
            }

        }
        return min_cost;
    }
}
