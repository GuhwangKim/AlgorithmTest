package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution92 {
    public int[] solution(String msg) {
        List<Integer> answerList = new ArrayList<>();
        // 배열은 계속해서 커질 것임
        // 0~26까지는 1글자로 차있을 것임
        // 97~122 A~Z
        Map<String, Integer> alphaList = new HashMap<>();

        // key 알파벳, value 순서
        for (int i = 1; i < 28; i++) {
            alphaList.put(String.valueOf((char) (96 + i)), i);
        }

        // 1글자인 경우
        if (msg.length() == 1) {
            answerList.add(alphaList.get(msg));
        }

        for (int i = 0; i < msg.length(); i++) {
            for (int j = i; j < msg.length(); j++) {
                String currentAplha = msg.substring(i, j);
                if (alphaList.containsKey(currentAplha)) {
                    // 알파멧이 있으면 j를 옮김 = 더 길게 갈것
                    // 답 리스트에 담을 것
                    answerList.add(alphaList.get(currentAplha));
                    continue;
                } else {
                    // 알파벳이 없으면 등록하고 i를 옮김
                    alphaList.put(currentAplha, alphaList.size() + 1);
                    break;
                }
            }
        }
        int[] answerArr = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answerArr[i] = answerList.get(0);
        }
        return answerArr;
    }
}