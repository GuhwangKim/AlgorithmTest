package algorithmTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section5_7 {
	private String T(String str1, String str2) {
		String answer = "YES";
		Queue<Character> queue = new LinkedList<Character>();
		for(char x : str1.toCharArray()) {
			queue.offer(x);
		}
		for(char x : str2.toCharArray()) {
			if(queue.contains(x)) {
				if(x!=queue.poll()) {
					return "NO";
				}
			}
		}
		if(!queue.isEmpty()) {
			answer="NO";
		}
		return answer;
	}
	public static void main(String[] args) {
		Section5_7 section = new Section5_7();
		Scanner in = new Scanner(System.in);
		String str1 = in.nextLine();
		String str2 = in.nextLine();
		System.out.println(section.T(str1, str2));
	}

}
