package CodingTest.src.programmers_lv2;

public class Solution80 {
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(true){
            a = a/2 + a%2;
            b = b/2 + b%2;
            answer++; // ÇÑÈ¸
            if(a==b){
                break;
            }
        }
        return answer;
    }
}
