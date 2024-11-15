package CodingTest.src.secondPrgrammers.lv2;

import java.util.Arrays;

/**
 * ����ĳ��
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 * */
public class Solution3 {
    static int[][] section;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // �ּ����� �Ƿε� (���� �پ��̸��θ� ä�� ���� vs ������ ������ �°� ������ ���� ���)
        int cnt = Math.min(minerals.length / 5 + 1, picks[0] + picks[1] + picks[2]);

        section = new int[cnt][3]; // 5���� ��� picks �ȿ� �ִ� ������ �Ƿε�
        int dp=0, ip=0, sp = 0;

        // ��� ���� ��ŭ ����
        for (int i = 0; i < minerals.length; i += 5) {
            if(i/5==cnt){
                break;
            }
            for (int j = i; j < i + 5; j++) {
                String m = minerals[j];
                if(m.equals("diamond")){
                    dp += 1;
                    ip += 5;
                    sp += 25;
                }
                else if(m.equals("iron")){
                    dp += 1;
                    ip += 1;
                    sp += 5;
                }
                else{
                    dp += 1;
                    ip += 1;
                    sp += 1;
                }
                if (j == minerals.length - 1) {
                    break;
                }
            }

            // ���� �̳׶� 5���� �ɰ� �� ��� �� �� ������
            section[i / 5][0] = dp;
            section[i / 5][1] = ip;
            section[i / 5][2] = sp;
            dp = ip = sp = 0; // �ʱ�ȭ
        }

        // [���� �ȵ�] ���� ĺ�� �� �Ƿε��� ���� ���� ������ ��������
        Arrays.sort(section, (o1, o2) -> o2[2] - o1[2]);

        // ���̾� -> ö -> ���� ������� ķ
        for (int i = 0; i < cnt; i++) {
            if (picks[0] != 0) {
                // ���̾Ʒ� ķ
                answer += section[i][0];
                picks[0]--; // �ϳ� ���� ��Ŵ (5������)
            } else if (picks[1] != 0) {
                answer += section[i][1];
                picks[1]--;
            } else if (picks[2] != 0) {
                answer += section[i][2];
                picks[2]--;
            }
        }
        return answer;
    }
}
