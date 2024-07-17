package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution92 {
    public int[] solution(String msg) {
        List<Integer> answerList = new ArrayList<>();
        // �迭�� ����ؼ� Ŀ�� ����
        // 0~26������ 1���ڷ� ������ ����
        // 97~122 A~Z
        Map<String, Integer> alphaList = new HashMap<>();

        // key ���ĺ�, value ����
        for (int i = 1; i < 28; i++) {
            alphaList.put(String.valueOf((char) (96 + i)), i);
        }

        // 1������ ���
        if (msg.length() == 1) {
            answerList.add(alphaList.get(msg));
        }

        for (int i = 0; i < msg.length(); i++) {
            for (int j = i; j < msg.length(); j++) {
                String currentAplha = msg.substring(i, j);
                if (alphaList.containsKey(currentAplha)) {
                    // ���ĸ��� ������ j�� �ű� = �� ��� ����
                    // �� ����Ʈ�� ���� ��
                    answerList.add(alphaList.get(currentAplha));
                    continue;
                } else {
                    // ���ĺ��� ������ ����ϰ� i�� �ű�
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