package algorithmTest;

public class Section7_2 {

	private void DFS(int i) {
		// 정도를 알려줌 
		if(i==0) {
			return; // 종료 
		}else {
			DFS(i-1);
			System.out.print(i+" ");
			// 자기를 호출하는 것 무한 반복 
			// D(3) -> D(2) -> D(1)ㅇ
		}
	}

	public static void main(String[] args) {
		Section7_2 section = new Section7_2();
		section.DFS(3);
	}

}
