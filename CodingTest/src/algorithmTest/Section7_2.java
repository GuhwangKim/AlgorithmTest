package algorithmTest;

public class Section7_2 {

	private void DFS(int i) {
		// ������ �˷��� 
		if(i==0) {
			return; // ���� 
		}else {
			DFS(i-1);
			System.out.print(i+" ");
			// �ڱ⸦ ȣ���ϴ� �� ���� �ݺ� 
			// D(3) -> D(2) -> D(1)��
		}
	}

	public static void main(String[] args) {
		Section7_2 section = new Section7_2();
		section.DFS(3);
	}

}
