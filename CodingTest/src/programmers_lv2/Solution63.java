package CodingTest.src.programmers_lv2;

import java.util.Stack;

public class Solution63 {

	public String solution(String p) {
		String answer = "";
		if (p.equals("")) {
			// 입력값이 빈 문자열이라면
			return "";
			// 빈문자열 반환함
		}

		answer = check(p);

		return answer;
	}

	private String check(String p) {
		if (p.equals("")) {
			// 입력값이 빈 문자열이라면
			return "";
			// 빈문자열 반환함
		}
		int right = 0;
		String strRight = "";
		int left = 0;
		String strLeft = "";

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == ')') {
				left++;
				strLeft += p.charAt(i);
			} else {
				right++;
				strRight += p.charAt(i);
			}
			if (left == right) {
				// 개수가 같을 떄 멈춤
				break;
			}
		}

		// u를 검증함 (올바른 문자열인지 아닌지)
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < strLeft.length(); i++) {
			if (stack.isEmpty()) {
				stack.add(strLeft.charAt(i));
				continue;
			}
			if (stack.peek() == strLeft.charAt(i)) {
				// 같은 괄호
				stack.add(strLeft.charAt(i));
				continue;
			} else {
				// 다른 괄호
				stack.pop();
				// stack에 있는 것을 없앰
			}
		}

		if (stack.size() == 0) {
			// 올바른 문자열
			return strLeft + check(strRight);
		} else {
			// 올바른 문자열이 아님
			String fbrmvd = strLeft.substring(1, strLeft.length() - 1);
			String result = "";
			for (int i = 0; i < fbrmvd.length(); i++) {
				if (fbrmvd.charAt(i) == ')') {
					result += '(';
				} else {
					result += ')';
				}
			}
			return "("+check(strRight)+")" + result;

		}

	}
}
