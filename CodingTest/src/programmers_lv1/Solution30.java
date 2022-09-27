package programmers_lv1;

public class Solution30 {
	public String solution(String phone_number) {
        String answer = "";
        
        int x=phone_number.length();
        
        for (int i = 0; i < x-4; i++) {
			answer+="*";
		}
        answer+=phone_number.substring(x-4, x);
        
        return answer;
    }

}
