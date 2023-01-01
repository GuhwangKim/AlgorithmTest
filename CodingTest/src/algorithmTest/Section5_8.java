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
			Person tmp = q.poll(); // 1. queue 에 있는 값을 빼면서 변수에 담아주고 지움 
			for(Person x : q) { // 2. 뒤에 값들과 대소 비교  
				if(x.value>tmp.value) { // 3-1. 뒤에 값들이 큰 게 있다면 
					q.offer(tmp); // -> 뺀 것을 뒤에 보내주고 이제 새로운 것을 뽑아야니까 
					tmp = null; // -> 변수를 비운 후에 
					break; // -> 반복문 탈출 
				}
			}
			if(tmp!=null) { // 3-2. 뽑은 값이 최대 
				// 3-2-1. 그 값이 찾는 값 진료 완료 
				if(tmp.num==b) {
					answer++;
					return answer;
				}else {
				// 3-2-2. 찾는 값이 아닐때 진료 완료  
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
