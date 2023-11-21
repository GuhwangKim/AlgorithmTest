package CodingTest.src.programmers_lv2;

import java.util.Stack;

public class Solution63 {

	public String solution(String p) {
		String answer = "";
		if (p.equals("")) {
			// �Է°��� �� ���ڿ��̶��
			return "";
			// ���ڿ� ��ȯ��
		}

		answer = check(p);

		return answer;
	}

	private String check(String p) {
		if (p.equals("")) {
			// �Է°��� �� ���ڿ��̶��
			return "";
			// ���ڿ� ��ȯ��
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
				// ������ ���� �� ����
				break;
			}
		}

		// u�� ������ (�ùٸ� ���ڿ����� �ƴ���)
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < strLeft.length(); i++) {
			if (stack.isEmpty()) {
				stack.add(strLeft.charAt(i));
				continue;
			}
			if (stack.peek() == strLeft.charAt(i)) {
				// ���� ��ȣ
				stack.add(strLeft.charAt(i));
				continue;
			} else {
				// �ٸ� ��ȣ
				stack.pop();
				// stack�� �ִ� ���� ����
			}
		}

		if (stack.size() == 0) {
			// �ùٸ� ���ڿ�
			return strLeft + check(strRight);
		} else {
			// �ùٸ� ���ڿ��� �ƴ�
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
