package CodingTest.src.secondPrgrammers.lv2;

import java.util.Arrays;

/**
 * 광물캐기
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 * */
public class Solution3 {
    static int[][] section;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // 최소한의 피로도 (모든게 다아이몬드로만 채취 가능 vs 도구의 종류에 맞게 광물이 있을 경우)
        int cnt = Math.min(minerals.length / 5 + 1, picks[0] + picks[1] + picks[2]);

        section = new int[cnt][3]; // 5개씩 묶어서 picks 안에 있는 광물별 피로도
        int dp=0, ip=0, sp = 0;

        // 곡괭이 개수 만큼 세기
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

            // 각각 미네랄 5개씩 쪼갠 후 모든 걸 한 광물씩
            section[i / 5][0] = dp;
            section[i / 5][1] = ip;
            section[i / 5][2] = sp;
            dp = ip = sp = 0; // 초기화
        }

        // [이해 안됨] 돌로 캤을 때 피로도가 가장 높은 순으로 내림차순
        Arrays.sort(section, (o1, o2) -> o2[2] - o1[2]);

        // 다이아 -> 철 -> 돌로 순서대로 캠
        for (int i = 0; i < cnt; i++) {
            if (picks[0] != 0) {
                // 다이아로 캠
                answer += section[i][0];
                picks[0]--; // 하나 제외 시킴 (5개까지)
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
