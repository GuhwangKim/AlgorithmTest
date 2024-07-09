package CodingTest.src.programmers_lv2;

public class Solution91 {
    public int solution(int n) {
        int sum1 = 0;
        int sum2 = 1;
        int sum3 = 0;
        for (int i = 1; i < n; i++) {
            System.out.println("sum1 : "+sum1);
            System.out.println("sum2 : "+sum2);
            sum3 = cal(sum1, sum2);
            System.out.println("sum3 : "+sum3);
            sum1 = sum2;
            sum2 = sum3;
            System.out.println("sum1 : "+sum1);
            System.out.println("sum2 : "+sum2);
        }

        return sum3%1234567;
    }
    public int cal(int sum1, int sum2) {
        return sum1 + sum2;
    }
}
