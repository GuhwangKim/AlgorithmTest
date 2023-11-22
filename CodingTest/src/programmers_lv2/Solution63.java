package CodingTest.src.programmers_lv2;

import java.util.Stack;

public class Solution63 {

	public String solution(String p) {
		String answer = check(p);

		return answer;
	}

	private String check(String p) {
		if (p.length()==0) {
			// 입력값이 빈 문자열이라면
			return "";
			// 빈문자열 반환함
		}
		int left = 0;
		String strLeft = "";
		int right = 0;
		String strRight = "";

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == ')') {
				left++;
			} else {
				right++;
			}
			strLeft += p.charAt(i); // 왼쪽에 쌓임
			if (left == right) {
				// 개수가 같을 떄 멈춤 오른쪽을 
				strRight += p.substring(i+1);
				break;
			}
		}

		if (isCorrect(strLeft)) {
			// 올바른 문자열
			return strLeft + check(strRight);
		} else {
			// 올바른 문자열이 아님
			String temp = "(";
			temp += check(strRight);
			temp += ")";
			String fbrmvd = strLeft.substring(1, strLeft.length() - 1);
			String result = "";
			for (int i = 0; i < fbrmvd.length(); i++) {
				if (fbrmvd.charAt(i) == ')') {
					result += '(';
				} else {
					result += ')';
				}
			}
			return  temp += result;
		}

	}
	
	private boolean isCorrect(String strLeft) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < strLeft.length(); i++) {
			if(strLeft.charAt(i)=='(') {
				// 올바른 경우 
				stack.push('(');
			}else {
				if(stack.isEmpty() || stack.peek()==')') {
					return false;
				}else {
					stack.pop();
				}
			}
		}
		return true;
	}
}
