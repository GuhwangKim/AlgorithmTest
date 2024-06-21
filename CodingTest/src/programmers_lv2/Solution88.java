package CodingTest.src.programmers_lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution88 {
    public int solution(int[] arr) {
        int answer = 0;
        // 최대공약수 구함 
//        Queue<Integer> queue = new LinkedList<Integer>();
//        Arrays.stream(arr).filter(value -> queue.add(value));
//        while (queue.size()>1) {
//			queue.add(lcm(queue.poll(), queue.poll()));
//		}
        // 해당 방법 너무 번거로워서 재귀함수로 
        
        int gcd = getGCD(arr[0], arr[1]);
        int lcm = (arr[0]*arr[1])/gcd;
        
        for (int i = 2; i < arr.length; i++) {
			gcd = getGCD(lcm, arr[i]);
			lcm = (lcm * arr[i]) / gcd;
		}
        
        // 모든 숫자를 곱한 값 / 최대공약수

        return lcm;
    }
    
    public int getGCD (int a, int b) {
    	if(a%b==0) {
    		return b;
    	}
    	return getGCD(b, a%b);
    }

}
