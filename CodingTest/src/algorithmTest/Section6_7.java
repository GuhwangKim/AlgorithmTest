package algorithmTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class function implements Comparable<function> {
	int x;
	int y;
	public function(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(function o) {
		if(this.x==o.x) {
			return this.y-o.y;
		}else {
			return this.x-o.x;
		}
		// ���� ������ �Ű������� o. ���� 
		// �������� ������ ���ϵǵ��� ��  
	}
}

public class Section6_7 {

	public static void main(String[] args) {
		Section6_7 section = new Section6_7();
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		ArrayList<function> list = new ArrayList<function>();
		for (int i = 0; i < a; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			list.add(new function(x, y));
		}
		Collections.sort(list);
		// ������ ������ compareTo�� �� 
		for(function o : list) {
			System.out.println(o.x+" "+o.y);
		}
	}

}
