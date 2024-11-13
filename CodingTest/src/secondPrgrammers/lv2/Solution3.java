package CodingTest.src.secondPrgrammers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ����ĳ��
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

        int pick_cnt = Arrays.stream(picks).sum(); // ��� ��� ��
        int work_cnt = Math.min(pick_cnt * 5, minerals.length); // �ִ� �۾��� (�Ƿε��� ������, Ķ �� �ִ� ������ ��)

        for (int i = 0; i < work_cnt; i++) {
            // �ִ� �۾����� ��������
            int d_cost = 0;
            int i_cost = 0;
            int s_cost = 0;

            // �ִ� �۾��� �� ��̴� 5��
            for (int j = 0; j < 5; j++) {
                // ** ��� + ���� �̳׶�
                int next = i + j;
                if (next == work_cnt) {
                    break;
                }
                // � ��̰� ������ ���� �̳׶� �� �Ҹ�
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
        // ��� ���� ��� ���� ������ ����

        int min_cost = 0;
        for (int i = 0; i < stress.size(); i++) {
            if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
                break; // � ��̵� ����
            }

            if (picks[0] > 0) {
                // ���̾� ����
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
