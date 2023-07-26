package CodingTest.src.programmers_lv2;

public class Solution24 {
    public int solution(int storey) {
        int answer = 0;
        int count = storey;
        // 가장 최대로 내려오는 방법 -1
        /**
         * storey + button의 값들을 조합해서 = 0
         * 그떄의 count를 저장하고
         * 그 중 가장 최소 값을 구함
         *
         * */
        
        int lastNum = storey%10;
        
        if(lastNum>5) {
        	answer+=(10-lastNum);
        	
        }else if (lastNum==5) {
			
        	
		} else {
			answer += lastNum;
			
		}


        return answer;
    }
}
