package programmers_lv2;

import java.util.ArrayDeque;
import java.util.Queue;


public class Solution1 {
	class Solution {
	    public int solution(int[] queue1, int[] queue2) {
	        long sum1=0; //각각의 합을 뽑아내야함
	        long sum2=0;
	        long sum=0;
	        
	        Queue<Integer> stack1 = new ArrayDeque<Integer>();
	        Queue<Integer> stack2 = new ArrayDeque<Integer>();
	        
	        for(int x : queue1) {
	        	stack1.add(x);
	        	sum1+=x;
	        }
	        
	        for(int y: queue2) {
	        	stack2.add(y);
	        	sum2+=y;
	        }
	        sum=sum1+sum2;
	        if(sum%2==1) {
	        	return -1;
	        }
	        sum/=2;
	        int q1=0; // 횟수 분리 
	        int q2=0; // 횟수
	        int limit=queue1.length*2;
	        
	        while(q1<=limit&&q2<=limit) { // 언제까지 조건을 반복할 것인지 지정
	        	if(sum1==sum) {
	        		return q1+q2;
	        	}
	        	if(sum1>sum) {
	        		sum1-=stack1.peek();
	        		sum2+=stack1.peek();
	        		stack2.add(stack1.poll());
	        		q1++;
	        	}else {
	        		sum2-=stack2.peek();
	        		sum1+=stack2.peek();
	        		stack1.add(stack2.poll());
	        		q2++;
	        	}
	        }
	        return -1;
	    }
	}
}
