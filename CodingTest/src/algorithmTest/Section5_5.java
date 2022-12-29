package algorithmTest;

import java.util.Scanner;
import java.util.Stack;

public class Section5_5 {

	private int T(char[] arr) {
		int answer = 0;
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i]=='(') { // 1. ¿­¸° °ýÈ£ 
				stack.add(arr[i]);
			} else {			// 2. ´ÝÈù °ýÈ£ 
				stack.pop(); // ¾ø¾Ú 
				if(arr[i-1]=='(') { // ·¹ÀÌÀúÀÎ°æ¿ì 
					answer+=stack.size();
				}else { // ¼è¸·´ë±âÀÇ ³¡ 
					answer++; 
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Section5_5 section = new Section5_5();
		
		Scanner in = new Scanner(System.in);
		String str = in.next();
		char[] arr = str.toCharArray();
		
		System.out.println(section.T(arr));
	}
}
