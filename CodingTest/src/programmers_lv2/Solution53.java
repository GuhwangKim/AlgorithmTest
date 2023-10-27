package CodingTest.src.programmers_lv2;

public class Solution53 {
    public int solution(int[] a) {
        int answer = 0;
        /**
         * 처음부터 끝까지 하나씩 없애봄
         * 1.a의 사이즈가 2
         *  1) small = 1 answer+2 (작은거/큰거 지움)
         *  2) small = 0 answer+1 (큰거 지움)
         *2. 처음부터 2개씩 조합해봄
         * 작은것
         * 큰것
         * 나누는 것으로 계속해서 연결해봄
         *
         * */
        String wholeNums = "";
        for(int num : a){
            wholeNums += String.valueOf(num);
        }

        int small = 1;
        // 하나 주어짐
        StringBuilder str = new StringBuilder();
        // 비교하는 것 가능하겠는데, 이 이후에 지우고 다시 합치는 것을 어떻게?

        for (int i = 0; i < wholeNums.length()-1; i++) {
            // 가장 마지막 그 앞에 인덱스 까지만 해서 2개의 수를 조합함
            str.append(wholeNums.substring(0, i));
            // 앞에 부분 합치기


            if(a[i]>a[i+1]){
            // 작은 거 없애는 경우


            }

            str.append(wholeNums.substring())
            // 뒤에 부분 합치기


        }

        return answer;
    }
}
