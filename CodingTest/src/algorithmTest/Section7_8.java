package algorithmTest;

public class Section7_8 {
	Node root;
	public int DFS(int L, Node root) {
		if(root.lt==null && root.rt==null) {
			// 가장 마지막 노드 이면 
			return L;
		} else {
			return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
			// 왼쪽 부터 다 한 후에 => 오른쪽 
		}
	}

	public static void main(String[] args) {
		Section7_8 tree = new Section7_8();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		System.out.println(tree.DFS(0, tree.root));
	}
}
