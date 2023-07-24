package CodingTest.src.programmers_lv2;

public class Solution23 {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int subs = 0;
        int purchase = 0;



        for (int i = 0; i < users.length; i++) {
            int sum = 0;
            int maxPercent = users[i][0];
            int minPercent = 0;

            while (minPercent <= maxPercent){
               long mid = (maxPercent + minPercent)/2;
                for (int price : emoticons){
                    sum += (price*(1-(mid)*0.01));
                }
                if(sum>=users[i][1]){
                    subs++;
                } else{
                    purchase+=sum;
                }
            }



        }
        answer[0] = subs;
        answer[1] = purchase;

        return answer;
    }
}
