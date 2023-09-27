package programmers_kit.repeat2;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Array1 {
	public String solution(int[] numbers) {
		String[] stringNum = new String[numbers.length];
		
		// 모두 0이 나올떄가 문제임 
		
		boolean allOne = true;
		
		for (int i = 0; i < stringNum.length; i++) {
			if(allOne &&  numbers[i]!=0) {
				allOne = false;
				// 하나라도 숫자가 있으면 다 0 이 아님 
			}
			stringNum[i] = String.valueOf(numbers[i]);
		}

		if(allOne) {
			return "0";
			
		}
		
		String answer;
		answer = Arrays.stream(stringNum).sorted((o1, o2) -> (o2+o1).compareTo(o1+o2)).collect(Collectors.joining());
		// 앞뒤로 비교해서 더해주고 큰 값을 합침 
		
		
		return answer;
		
	}
	

}
