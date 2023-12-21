package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution73 {
        HashMap<String, Integer> dict = new HashMap<>();
    public int[] solution(String msg) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();

        int dictIdx = 1;
        for (int i = 'A'; i <= 'Z'; i++) {
            //  A Z 까지 담기
            dict.put(String.valueOf((char) i), dictIdx++);
        }

        int idx = 0;
        while (idx < msg.length()) {
            String w = "";
            while (idx < msg.length()) {
                if (!dict.containsKey(w + msg.charAt(idx))) {
                    // 포함이 안되어있으면 건너뜀
                    break;
                } else {
                    // 포함되어 있으면 글자를 붙힘
                    w += msg.charAt(idx);
                }
                idx++;
            }
            ans.add(dict.get(w));
            if (idx < msg.length()) {
                dict.put(w + msg.charAt(idx), dictIdx++);
            }
            answer = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                answer[i] = ans.get(i);
            }
        }
        return answer;
    }
}
