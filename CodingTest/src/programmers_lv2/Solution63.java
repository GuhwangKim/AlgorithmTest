package CodingTest.src.programmers_lv2;

import java.util.Stack;

public class Solution63 {
    public String solution(String p) {
        String answer = "";
        /**
         * 1) right ( left ) 의 개수가 같으면 2 부분으로 나뉨
         * 2) 두 번쨰 있는 값이 "" 일 때까지 계속해서 반복해야함
         * 3) "" 값이면 앞에 있는 값을 가장 앞 뒤 를 제거하고 나머지 값들을 반대로 해서 return
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
               // 개수가 같을 떄 멈춤
              splitTwo[0] = strLeft; // u
              splitTwo[1] = strRight; // v
           }
        }

        // u를 검증함 (올바른 문자열인지 아닌지)
        Stack<Character> stack = new Stack<>();
        stack.add(strLeft.charAt(0));
        for (int i = 0; i < strLeft.length(); i++) {

        }
        





        return answer;
    }
}
