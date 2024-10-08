package CodingTest.src.programmers_lv2;

public class Solution106 {
    public int solution(String s)
    {
        int answer = 1;

        // 우선 1글자, 2글자 일때, 1글자는 무조건 1 / 2글자는 같을 떄 2 다르면 1
        // 3글자 이상부터 시작

        // 최대값을 구하는 것이기 때문에 우선 반으로 나누어서
        // 반에서 시작한 후 왼쪽(1까지만) 오른쪽(길이 -1) 으로 탐색
        // 홀수 일 때 나눈 몫에서 시작
        // 짝수 일 때 몫과 몫 -1 에서 시작
        // 앞과 뒤의 숫자를 비교한 후, 같으면 그 더하고 다르면 빠져나옴 그 다음 인덱스로

        if (s.length() == 1) {
            return 1;
        } else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return 2;
            }else{
                return 1;
            }
        }

        // 3이상
        int divide = s.length() / 2;

        // 앞으로 비교
        for (int i = divide; i >0 ; i--) {
            int tmp = check(i, s);
            answer = Math.max(answer, tmp);

            // divide 위치 바뀜
        }
        if (answer == s.length()) {
            // 가장 최대값
            return answer;
        }
        // 뒤로 비교
        for (int i = divide+1; i < s.length()-1; i++) {
            int tmp = check(i, s);
            answer = Math.max(answer, tmp);
        }
        return answer;
    }

    private int check(int index, String s) {
        int i = 1;
        int answer = 1;
        while (index - i > 0 && index < s.length()) {
            if (s.charAt(index - 1) == s.charAt(index + 1)) {
                answer += 2;
                i++;
            }else{
                break;
            }
        }
        return answer;
    }
}
