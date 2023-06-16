package programmers_kit.repeat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1. Math.ceil (정수) 가 들어갈 경우에도 올림해버림 
 * 2. 마지막 연산에서 count 값을 list 에 담아주는 작업 
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
