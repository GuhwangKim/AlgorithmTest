package programmers_lv2;

public class Solution71 {
	public String solution(int n, int t, int m, int p) {
        // 숫자를 나열해보자 1~ n진법으로 변환해서 붙히기 
        // (p순서+m인원수 * t-1) 까지만 구하면 됨 
        
        StringBuilder convert = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; convert.length() <= t*m; i++) {
			// 본인의 순서 + 참가한 인원 만큼 더함 = 말해야하는 숫자 
        	convert.append(Integer.toString(i, n));
		}
        
        for (int i = p-1; answer.length() < t; i+=m) {
			// 인덱스이기 때문에 p 순서 -1 , t보다 작을 때 
        	answer.append(convert.charAt(i));
		}
        
        return answer.toString().toUpperCase();
    }

}
