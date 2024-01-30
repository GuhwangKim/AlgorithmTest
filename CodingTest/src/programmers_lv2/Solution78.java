package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public int solution(String str1, String str2) {
        int answer = 0;

        // ���ڿ� �빮�ڷ� �� �����ϱ�
        str1.toUpperCase();
        str2.toUpperCase();
        
        List<String> str1List = getElement(str1);
        List<String> str2List = getElement(str2);
        
        

        return answer;
    }

    // ���ڿ��� �� ���ڷ� �ڸ� ���Ҹ� �ִ� ����Ʈ 
    private List<String> getElement(String str) {
        List<String> strList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            int str1Num = (int) str.charAt(i);
            int str2Num = (int) str.charAt(i+1);

            // ���ڿ� -> ���� ASCII �ڵ�� �����ڸ� (Ư������ ����)
            if((64 < str1Num && str1Num <91) || (96 < str1Num && str1Num <123)){
                if((64 < str2Num && str2Num <91) || (96 < str2Num && str2Num <123)){
                    strList.add(String.valueOf((char) str1Num).concat(String.valueOf((char) str2Num)));
                    // �� ���ڸ� > char �� �ٲ��� > concat ���� ��ħ
                }
            }
        }
        
        
        return strList;
    }


}
