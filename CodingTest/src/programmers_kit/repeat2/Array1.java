package programmers_kit.repeat2;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Array1 {
	public String solution(int[] numbers) {
		String[] stringNum = new String[numbers.length];
		
		// ��� 0�� ���Ë��� ������ 
		
		boolean allOne = true;
		
		for (int i = 0; i < stringNum.length; i++) {
			if(allOne &&  numbers[i]!=0) {
				allOne = false;
				// �ϳ��� ���ڰ� ������ �� 0 �� �ƴ� 
			}
			stringNum[i] = String.valueOf(numbers[i]);
		}

		if(allOne) {
			return "0";
			
		}
		
		String answer;
		answer = Arrays.stream(stringNum).sorted((o1, o2) -> (o2+o1).compareTo(o1+o2)).collect(Collectors.joining());
		// �յڷ� ���ؼ� �����ְ� ū ���� ��ħ 
		
		
		return answer;
		
	}
	

}
