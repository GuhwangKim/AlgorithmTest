package CodingTest.src.programmers_lv2;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public int solution(String str1, String str2) {
        int answer = 0;

        // 문자열 대문자로 다 변경하기
        str1.toUpperCase();
        str2.toUpperCase();
        
        List<String> str1List = getElement(str1);
        List<String> str2List = getElement(str2);

        return jacquard(str1List, str1List);
    }

    private int jacquard(List<String> strList1, List<String> strList2) {
    	
    	if(strList1.size() == 0 && strList2.size()==0) {
    		return 65536;
    	}
    	
    	int min = 0;
    	int max = strList1.size() + strList2.size();
    	// 가장 클 때는 서로 다 다를때 
    	
    	for(String str : strList1) {
    		for (int i = 0; i < strList2.size(); i++) {
				if(str.equals(strList2.get(i))) {
					// 값이 갔다면 
					min++;
					strList2.remove(i);
					// 해당 값은 해당이 됬으므로 지워짐 
					break; // 다음 원소로 
				}
			}
    	}
    	
    	max =max - min;
    	double result = (double) min/max;
    	return (int) (result*65536);
	}

	// 문자열을 두 글자로 자른 원소를 넣는 리스트 
    private List<String> getElement(String str) {
        List<String> strList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            int str1Num = (int) str.charAt(i);
            int str2Num = (int) str.charAt(i+1);

            // 문자열 -> 숫자 ASCII 코드로 영문자만 (특수문자 제외)
            if((64 < str1Num && str1Num <91) || (96 < str1Num && str1Num <123)){
                if((64 < str2Num && str2Num <91) || (96 < str2Num && str2Num <123)){
                    strList.add(String.valueOf((char) str1Num).concat(String.valueOf((char) str2Num)));
                    // 두 숫자를 > char 로 바꾼후 > concat 으로 합침
                }
            }
        }
        
        
        return strList;
    }


}
