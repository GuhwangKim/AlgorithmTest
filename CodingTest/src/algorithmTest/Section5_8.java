package algorithmTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
	int num;
	int value;
	public Person(int num, int value) {
		super();
		this.num = num;
		this.value = value;
	}
}

public class Section5_8 {
	private int T(int a, int b, int[] arr) {
		int answer = 0;
		Queue<Person> q = new LinkedList<Person>();
		for (int i = 0; i < arr.length; i++) {
			q.offer(new Person(i, arr[i]));
		}
		while(!q.isEmpty()) {
			Person tmp = q.poll(); // 1. queue �� �ִ� ���� ���鼭 ������ ����ְ� ���� 
			for(Person x : q) { // 2. �ڿ� ����� ��� ��  
				if(x.value>tmp.value) { // 3-1. �ڿ� ������ ū �� �ִٸ� 
					q.offer(tmp); // -> �� ���� �ڿ� �����ְ� ���� ���ο� ���� �̾ƾߴϱ� 
					tmp = null; // -> ������ ��� �Ŀ� 
					break; // -> �ݺ��� Ż�� 
				}
			}
			if(tmp!=null) { // 3-2. ���� ���� �ִ� 
				// 3-2-1. �� ���� ã�� �� ���� �Ϸ� 
				if(tmp.num==b) {
					answer++;
					return answer;
				}else {
				// 3-2-2. ã�� ���� �ƴҶ� ���� �Ϸ�  
					answer++;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Section5_8 section = new Section5_8();
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		in.nextLine();
		String str2 = in.nextLine();
		String[] sarr = str2.split(" ");
		int[] arr = new int[a];
		for (int i = 0; i < sarr.length; i++) {
			arr[i]=Integer.parseInt(sarr[i]);
		}
		System.out.println(section.T(a, b, arr));
	}

}
