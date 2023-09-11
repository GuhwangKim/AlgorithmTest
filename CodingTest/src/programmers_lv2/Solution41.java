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
			// 현재 Node의 앞, 뒤 정보 담아주기
			nodeArr[i] = new Node();
			nodeArr[i].prev = nodeArr[i - 1];
			nodeArr[i - 1].next = nodeArr[i];
		}

		Stack<Node> delete = new Stack<>();
		// 지울 history 쌓기
		Node now = nodeArr[k];
		// 현재 위치

		for (String each : cmd) {
			if (each.charAt(0) == 'D') {
				// 위
				int cnt = Integer.parseInt(each.substring(2));
				for (int i = 0; i < cnt; i++) {
					now = now.next;
					// 현재 위치가 -1 씩 2번이 되고 있음
				}

			} else if (each.charAt(0) == 'U') {
				// 아래
				int cnt = Integer.parseInt(each.substring(2));
				for (int i = 0; i < cnt; i++) {
					now = now.prev;
					// 현재 위치가 1 씩 2번이 되고 있음
				}

			} else if (each.charAt(0) == 'C') {
				// 삭제 후 아래
				now.isDelete = true;
				delete.push(now);
				// history 쌓아올라옴
				Node prev = now.prev;
				Node next = now.next;

				if (prev != null) {
					// 전 값이 있다면
					prev.next = next;
				}
				if (next != null) {
					// 다음 값이 있다면
					next.prev = prev;
					now = next;
				} else {
					// 현재 값은 전 값과 같음
					now = prev;
				}

			} else {
				// 복구
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
