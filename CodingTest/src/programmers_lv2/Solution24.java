package CodingTest.src.programmers_lv2;

public class Solution24 {
    public int solution(int storey) {
        int answer = 0;
        int count = storey;
        // ���� �ִ�� �������� ��� -1
        /**
         * storey + button�� ������ �����ؼ� = 0
         * �׋��� count�� �����ϰ�
         * �� �� ���� �ּ� ���� ����
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
