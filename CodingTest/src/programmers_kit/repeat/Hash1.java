package CodingTest.src.programmers_kit.repeat;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * Strig ������ �⺻ ������ ����
 * �⺻������ 1�� �켱���� ���ĵǰ�, ���̿� ���� ��������
 * */

public class Hash1 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
       // �� ��ȣ�� �ٸ� ��ȣ�� ���λ��� ��� ������ ��� ����
        // ���λ��� ���� ū ��ȣ�� �� �� �����Ƿ� ����
        // ���ĺ��� ���� ���� => 1�� �켱���� ���� ������ ���� ***

        for (int i = 0; i < phone_book.length; i++) {
            if(phone_book[i+1].startsWith(phone_book[i]))
                return false;
        }
        return true;
    }
}
