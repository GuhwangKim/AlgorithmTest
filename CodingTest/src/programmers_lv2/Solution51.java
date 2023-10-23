package CodingTest.src.programmers_lv2;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution51 {
    static int totalChange=0;
    static int totalZero = 0;

    public int[] solution(String s) {
        int[] answer = new int[2];

        checkOne(s, 1);
        answer[0] = totalChange;
        answer[1] = totalZero;

        return answer;
    }

    private void checkOne(String s, int cnt) {
        if(s.equals("1")){
            totalChange = cnt;
            return;
        }
        // string�� streamȭ ��
        char[] word = s.toCharArray();
        IntStream intStream = IntStream.range(0, word.length);
        Stream<Character> charStream = intStream.mapToObj(i->word[i]);

        // 0�� ���� ����
        int zeroCnt = (int) charStream.filter(c->c=='0').count();
        totalZero+=zeroCnt;

        // 1�� �ƴ� ���� �����ؼ� ��ħ
        String newStr = charStream.filter(i -> i!='0').map(Object::toString).collect(Collectors.joining());
        checkOne(newStr, cnt++);
    }
}
