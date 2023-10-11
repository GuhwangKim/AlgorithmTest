package CodingTest.src.programmers_lv2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution47 {
    public String solution(String play_time, String adv_time, String[] logs) throws ParseException {
        String answer = "";
        /**
         * 1. logs에 있는 시작 끝을 저장하는 2차원 배열을 만듦 (int)
         * 2. max, maxKey (시작점), cnt 를 변수로 해서
         * 3. end start를 비교함
         *      end>=start 겹침 cnt 추가
         *      end<start 끝 cnt 초기화, end 값 변경
         *          max <cnt  maxKey값 start값으로 변경함
         *          max>=cnt 그대로
         * 4. maxKey 값을 다시 시분초 형태로 변환하여 반환
         * */
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        long[][] logsArr = new long[logs.length][2];

        // logs에 있는 시간 변환작업
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
