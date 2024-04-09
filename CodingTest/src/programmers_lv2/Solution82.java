package CodingTest.src.programmers_lv2;

public class Solution82 {
    public int solution(int n) {
        int ans = 0;
        // 2의 배수 -> 순간이동 (현재까지 온 거리 * 2 로 이동하는 개념임)
        // 1 만큼 이동 -> ans에 더해짐

        // 1 만큼 일단 이동 -> 2*배수 = n 값 나올 때까지 이동 함
        // 1 + 1*2 + 2*2 + 4*2 + 6-2의 2승 = 4 =
        while(n!=0){
            if(n%2==0){
                // 짝수일때
                n/=2;
                // 나누기
            } else{
                n--;
                // 한걸음 걷기
                ans++;
            }
        }
        return ans;
    }
}
