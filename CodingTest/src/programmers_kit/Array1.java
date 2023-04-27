package programmers_kit;

import java.util.Arrays;
import java.util.Comparator;

public class Array2 {
	public String solution(int[] numbers) {
		String answer = "";
		boolean flag = true;
		/*
		 * 1. ��� �ڸ����� 1000������ ���� 2. ������ �ű�
		 */
		String[] texts = new String[numbers.length];

		for (int i = 0; i < texts.length; i++) {
			if(numbers[i]!=0) {
				flag = false;
			}
			texts[i] = String.valueOf(numbers[i]);
		}
		if(flag) {
			return "0";
		}
		
		Arrays.sort(texts, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		
		for(String s : texts) {
			answer += s; 
		}

		return answer;

	}
}
