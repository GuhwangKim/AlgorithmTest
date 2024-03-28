package CodingTest.src.programmers_lv2;

import java.util.HashMap;
import java.util.Map;

public class Solution81 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        // ** 사용한 단어 저장 Map key 가 중복될 수 없으므로 key 를 단어로
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if(i!=0){
                String front = words[i-1]; //앞 단어
                String back = words[i];

                // 글자 추출
                char last = front.charAt(front.length()-1);
                char first = back.charAt(0);

                if(last!=first || map.containsKey(back)){
                    answer[0] = (i%n)+1; // 누구인지
                    answer[1] = (i/n)+1; // 차례

                    return answer;
                }
            }
            map.put(words[i], 1); // 사용한 단어
        }

        return answer;
    }
}
