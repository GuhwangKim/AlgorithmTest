package CodingTest.src.programmers_kit.repeat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 정렬을 숫자 1개로만 하는 것이 아니라 "조합한 숫자"를 기준으로 정렬을 함 
 * */

public class Array1 {
    public String solution(int[] numbers) {
        String answer ="";
        boolean checkOne = true;
        String[] string = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
        	if(checkOne==true && numbers[i]!=0) {
        		checkOne=false;
        	}
            string[i]=String.valueOf(numbers[i]);
        }
        
        if(checkOne)
        	return "0";
        
        answer = Arrays.stream(string).sorted((o1, o2)->(o2+o1).compareTo(o1+o2)).collect(Collectors.joining());
        return answer;
    }
}
