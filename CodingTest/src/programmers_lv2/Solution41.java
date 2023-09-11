package programmers_lv2;

import java.util.LinkedList;
import java.util.Stack;

public class Solution41 {
	static class Node {
		Node prev = null;
		Node next = null;
		boolean isDelete;
	}

	public String solution(int n, int k, String[] cmd) {
		Node[] nodeArr = new Node[10000];

		nodeArr[0] = new Node();

		for (int i = 1; i < n; i++) {
			// ���� Node�� ��, �� ���� ����ֱ�
			nodeArr[i] = new Node();
			nodeArr[i].prev = nodeArr[i - 1];
			nodeArr[i - 1].next = nodeArr[i];
		}

		Stack<Node> delete = new Stack<>();
		// ���� history �ױ�
		Node now = nodeArr[k];
		// ���� ��ġ

		for (String each : cmd) {
			if (each.charAt(0) == 'D') {
				// ��
				int cnt = Integer.parseInt(each.substring(2));
				for (int i = 0; i < cnt; i++) {
					now = now.next;
					// ���� ��ġ�� -1 �� 2���� �ǰ� ����
				}

			} else if (each.charAt(0) == 'U') {
				// �Ʒ�
				int cnt = Integer.parseInt(each.substring(2));
				for (int i = 0; i < cnt; i++) {
					now = now.prev;
					// ���� ��ġ�� 1 �� 2���� �ǰ� ����
				}

			} else if (each.charAt(0) == 'C') {
				// ���� �� �Ʒ�
				now.isDelete = true;
				delete.push(now);
				// history �׾ƿö��
				Node prev = now.prev;
				Node next = now.next;

				if (prev != null) {
					// �� ���� �ִٸ�
					prev.next = next;
				}
				if (next != null) {
					// ���� ���� �ִٸ�
					next.prev = prev;
					now = next;
				} else {
					// ���� ���� �� ���� ����
					now = prev;
				}

			} else {
				// ����
				Node node = delete.pop();
				Node prev = node.prev;
				Node next = node.next;

				node.isDelete = false;
				if (prev != null) {
					prev.next = node;
				}
				if (next != null) {
					next.prev = node;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (nodeArr[i].isDelete) {
				sb.append('X');
			} else {
				sb.append('0');
			}
		}

		return sb.toString();
	}

}
