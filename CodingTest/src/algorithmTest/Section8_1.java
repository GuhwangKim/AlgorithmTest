package algorithmTest;

import java.util.Scanner;

public class Section8_1 {
	Node root;
	public void DFS(Node root) {
		if(root==null) return; 
		else {
			DFS(root.lt);
			System.out.print(root.data+" ");
			DFS(root.rt);
		}
	}
	
	
	public static void main(String[] args) {
		Section8_1 tree = new Section8_1();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int[] arr = new int[a];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=in.nextInt();
		}
		
	}

}
