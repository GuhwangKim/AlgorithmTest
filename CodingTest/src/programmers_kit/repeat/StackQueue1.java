package programmers_kit.repeat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1. Math.ceil (����) �� �� ��쿡�� �ø��ع��� 
 * 2. ������ ���꿡�� count ���� list �� ����ִ� �۾� 
 * */


public class StackQueue1 {
	 public List<Integer> solution(int[] progresses, int[] speeds) {
		 List<Integer> list = new ArrayList<Integer>();
		 Queue<Integer> queue = new LinkedList<Integer>();
		 
		 
		 
		 for (int i = 0; i < progresses.length; i++) {
			queue.add((int) Math.ceil(100-(progresses[i]/speeds[i])));
		}
		 int count = 1;
		 int standNum = queue.poll();
		 while(!queue.isEmpty()) {
			 if(standNum>=queue.peek()) {
				 count+=1;
				 queue.poll();
			 } else {
				 standNum = queue.poll();
				 list.add(count);
				 count = 1;
			 }
			 
		 }
		 list.add(count);
		
		 return list;
	 }
}
