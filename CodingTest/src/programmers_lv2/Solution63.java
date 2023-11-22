package CodingTest.src.programmers_lv2;

import java.util.Stack;

public class Solution63 {

	public String solution(String p) {
		String answer = check(p);

		return answer;
	}

	private String check(String p) {
		if (p.length()==0) {
			// �Է°��� �� ���ڿ��̶��
			return "";
			// ���ڿ� ��ȯ��
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
			strLeft += p.charAt(i); // ���ʿ� ����
			if (left == right) {
				// ������ ���� �� ���� �������� 
				strRight += p.substring(i+1);
				break;
			}
		}

		if (isCorrect(strLeft)) {
			// �ùٸ� ���ڿ�
			return strLeft + check(strRight);
		} else {
			// �ùٸ� ���ڿ��� �ƴ�
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
				// �ùٸ� ��� 
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
