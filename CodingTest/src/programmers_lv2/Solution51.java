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
        // string을 stream화 함
        char[] word = s.toCharArray();
        IntStream intStream = IntStream.range(0, word.length);
        Stream<Character> charStream = intStream.mapToObj(i->word[i]);

        // 0인 것의 개수
        int zeroCnt = (int) charStream.filter(c->c=='0').count();
        totalZero+=zeroCnt;

        // 1이 아닌 것을 제외해서 합침
        String newStr = charStream.filter(i -> i!='0').map(Object::toString).collect(Collectors.joining());
        checkOne(newStr, cnt++);
    }
}
