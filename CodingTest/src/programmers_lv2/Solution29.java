package CodingTest.src.programmers_lv2;

import java.util.Arrays;

public class Solution29 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int aGCD = gcd(arrayA);
        int bGCD = gcd(arrayB);
        // 각각의 배열의 최대공약수를 구함

        // 기본 false
        boolean resultA = false;
        resultA = Arrays.stream(arrayA).anyMatch(value -> aGCD%value!=0); // 하나라도 안 나누어지면 true
        resultA = Arrays.stream(arrayB).anyMatch(value -> aGCD%value==0); // 하나라도 나누어지면 true

        boolean resultB = false;
        resultB = Arrays.stream(arrayB).anyMatch(value -> bGCD%value!=0); // 하나라도 안 나누어지면 true
        resultB = Arrays.stream(arrayA).anyMatch(value -> bGCD%value==0); // 하나라도 나누어지면 true

        if(!resultA && resultB){
            return aGCD;
        } else if (!resultB && resultA) {
            return bGCD;
        } else if (!resultA && !resultB) {
            answer = Math.max(aGCD, bGCD);
            return answer;
        } else{
            return 0;
        }
    }

    public static int gcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
