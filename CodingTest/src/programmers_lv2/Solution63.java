package CodingTest.src.programmers_lv2;

public class Solution63 {
    public String solution(String p) {
        String answer = "";
        /**
         * 1) right ( left ) �� ������ ������ 2 �κ����� ����
         * 2) �� ���� �ִ� ���� "" �� ������ ����ؼ� �ݺ��ؾ���
         * 3) "" ���̸� �տ� �ִ� ���� ���� �� �� �� �����ϰ� ������ ������ �ݴ�� �ؼ� return
         * */

        int right = 0;
        String strRight = "";
        int left = 0;
        String strLeft = "";

        String[] splitTwo = new String[2];
        for (int i = 0; i < p.length(); i++) {
           if(p.charAt(i)==')'){
               left++;
               strLeft+=p.charAt(i);
           } else{
               right++;
               strRight+=p.charAt(i);
           }
           if(left == right){
               // ������ ���� �� ����
              splitTwo[0] = strLeft;
              splitTwo[1] = strRight;
           }
        }




        return answer;
    }
}
