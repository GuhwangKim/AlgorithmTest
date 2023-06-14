package CodingTest.src.programmers_kit.repeat;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * Strig 정렬의 기본 원리를 이해
 * 기본적으로 1이 우선으로 정렬되고, 길이에 따라 차순으로
 * */

public class Hash1 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
       // 한 번호가 다른 번호의 접두사인 경우 순서는 상관 없음
        // 접두사인 경우는 큰 번호가 될 수 없으므로 정렬
        // 알파벳에 따른 정렬 => 1이 우선으로 정렬 다음은 길이 ***

        for (int i = 0; i < phone_book.length; i++) {
            if(phone_book[i+1].startsWith(phone_book[i]))
                return false;
        }
        return true;
    }
}
