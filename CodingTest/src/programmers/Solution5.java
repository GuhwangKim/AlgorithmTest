package programmers;

public class Solution5 {
	class Solution {
	    public int solution(String s) {
	        int answer = 0;
	        // replace (치환 문자, 바꿀 문자) 긴 문장 중에 앞 문자가 들어간다면
	        String[] arr= {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	        
	        for (int i = 0; i < arr.length; i++) {
				s=s.replace(arr[i], String.valueOf(i));
			}
	        answer=Integer.parseInt(s);
	        
	        return answer;
	    }
	}

}
