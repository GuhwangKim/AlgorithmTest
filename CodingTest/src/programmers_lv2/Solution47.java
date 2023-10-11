package CodingTest.src.programmers_lv2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution47 {
    public String solution(String play_time, String adv_time, String[] logs) throws ParseException {
        String answer = "";
        /**
         * 1. logs�� �ִ� ���� ���� �����ϴ� 2���� �迭�� ���� (int)
         * 2. max, maxKey (������), cnt �� ������ �ؼ�
         * 3. end start�� ����
         *      end>=start ��ħ cnt �߰�
         *      end<start �� cnt �ʱ�ȭ, end �� ����
         *          max <cnt  maxKey�� start������ ������
         *          max>=cnt �״��
         * 4. maxKey ���� �ٽ� �ú��� ���·� ��ȯ�Ͽ� ��ȯ
         * */
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        long[][] logsArr = new long[logs.length][2];

        // logs�� �ִ� �ð� ��ȯ�۾�
        for (int i = 0; i < logs.length ; i++) {
            String[] arr = logs[i].split("-");
            Date start = sdf.parse(arr[0]);
            Date end = sdf.parse(arr[1]);
            logsArr[i][0] = start.getTime();
            logsArr[i][1] = end.getTime();
        }

        int max = 0;
        int maxKey = 0;



        int cnt = 1;



        return answer;
    }
}
