package CodingTest.src.programmers_lv2;

import java.util.HashMap;
import java.util.Map;

public class Solution81 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        // ** ����� �ܾ� ���� Map key �� �ߺ��� �� �����Ƿ� key �� �ܾ��
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if(i!=0){
                String front = words[i-1]; //�� �ܾ�
                String back = words[i];

                // ���� ����
                char last = front.charAt(front.length()-1);
                char first = back.charAt(0);

                if(last!=first || map.containsKey(back)){
                    answer[0] = (i%n)+1; // ��������
                    answer[1] = (i/n)+1; // ����

                    return answer;
                }
            }
            map.put(words[i], 1); // ����� �ܾ�
        }

        return answer;
    }
}
