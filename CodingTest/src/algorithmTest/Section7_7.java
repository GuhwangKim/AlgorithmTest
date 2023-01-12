package algorithmTest;

import java.util.LinkedList;
import java.util.Queue;



public class Section7_7 {
	Node root;
	public void DFS(Node root) {
		Queue<Node> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size(); // 1�� 
			System.out.print(L+" : ");
			for (int i = 0; i < len; i++) {
				Node cur = Q.poll(); // ť�� �տ� �ִ� ��
				System.out.print(cur.data+" "); // 1 ���
				// ����� ���� queue �� ���� �ֱ� 
				if(cur.lt!=null) {
				// ���� ��� ���� �ִٸ� 
					Q.offer(cur.lt);
				}
				if(cur.rt!=null) {
				// ������ ��� ���� �ִٸ� 
					Q.offer(cur.rt);
				}
			}
			L++;
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Section7_7 tree = new Section7_7();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		tree.DFS(tree.root);
	}
}
