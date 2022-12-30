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
			Person tmp = q.poll(); // 1. queue 에 있는 값을 빼봄
			for(Person x : q) { // 2. 그 값의 value 값과 안에 있는 모든 값들의 value 값들의 대소 비교 
				if(x.value>tmp.value) {
					q.offer(tmp); // 3-1. 작으면 뒤로 보내줌 
					tmp = null;
					break;
				}
			}
			if(tmp!=null) {
				// 3-2. 최대값에 찾는 값일 때
				if(tmp.num==b) {
					answer++;
					return answer;
				}else {
				// 3-3. 최대값 이지만 찾는 값이 아닐때  
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
