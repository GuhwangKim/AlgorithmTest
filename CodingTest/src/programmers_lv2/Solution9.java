package CodingTest.src.programmers_lv2;

import java.util.*;

public class Solution9 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        /**
         * ���� �迭�� ���̰� ª�� ���� ��ȯ�ؾ���
         * Map ���� key
         * */
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < sequence.length; i++) {
            map.put(sequence[i], i);
        }

        List<Integer>  keys= new LinkedList<>(map.keySet());
        Collections.sort(keys, Collections.reverseOrder());
        int totalSum = 0;
        for (int i = 0; i < sequence.length; i++) {
            answer[i]=map.get(keys.get(i));
        }




        return answer;
    }
}
