package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Array1 {
    public String solution(int[] numbers) {
        String answer ="";
        String[] string = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            string[i]=String.valueOf(numbers[i]);
        }
        // ū���� �켱 ������ �� -> 30 3 �߿� 3�� �� �տ��;���.. ���?
        Arrays.sort(string, Comparator.reverseOrder());
        answer = Arrays.stream(string).collect(Collectors.joining());
        return answer;
    }
}
