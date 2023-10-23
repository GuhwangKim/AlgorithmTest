package programmers_lv2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution51 {
	
	static int totalChange=0;
	static int totalZero = 0;
	
	public static void main(String[] args) {
		Solution51 s = new Solution51();
		s.solution("110010101001");
	}

    public int[] solution(String s) {
        int[] answer = new int[2];

        checkOne(s, 1);
        answer[0] = totalChange;
        answer[1] = totalZero;

        return answer;
    }

    private void checkOne(String s, int cnt) {
        // string�� streamȭ ��
        String[] strArr = s.split("");

        // 0�� ���� ���� (int) strArr.filter(c->c=='0').count();
        int zeroCnt = (int) Arrays.stream(strArr).filter(str -> str.equals("0")).count();
        totalZero+=zeroCnt;

        // 1�� �ƴ� ���� �����ؼ� ��ħ
        String noZeroStr = Arrays.stream(strArr).filter(i -> !i.equals("0")).map(Object::toString).collect(Collectors.joining());
        String newStr = Integer.toBinaryString(noZeroStr.length());
        
        if(newStr.equals("1")){
            totalChange = cnt;
            return;
        }
        checkOne(newStr, cnt+1);
    }
}
