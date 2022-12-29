package algorithmTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section5_6 {

	private int T(int tot, int num) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <=tot; i++) {
			queue.offer(i);
		}
		while(queue.size()!=1) {
			for (int i = 1; i < num; i++) {
				queue.offer(queue.poll());
			}
			queue.poll();
		}
		return queue.poll();
	}

	public static void main(String[] args) {
		Section5_6 section = new Section5_6();
		Scanner in = new Scanner(System.in);
		int tot = in.nextInt();
		int num = in.nextInt();
		
		System.out.println(section.T(tot, num));
	}

}
