package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution89 {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split(" ");
        answer = Arrays.stream(strArr).map(s1 -> Character.toUpperCase(s1.charAt(0)) + s1.substring(1, s1.length()).toLowerCase()).collect(Collectors.joining(" "));
        return answer;
    }
}
