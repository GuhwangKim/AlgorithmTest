package CodingTest.src.programmers_lv2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution47 {


	public String solution(String play_time, String adv_time, String[] logs) throws ParseException {
		String answer = "";

		long playTime = intToTimes(play_time);
		long advTime = intToTimes(adv_time);
		long[] times = new long[360_000];

		// 1. �ʷ� ��ȯ�� �� �� �� ����, ���� ���� ��� 1�� ������
		for(String log : logs){
			String[] splitLog = log.split("-");

			long startTime = intToTimes(splitLog[0]);
			long endTime = intToTimes(splitLog[1]);
			for (int i = startTime; i < endTime; i++) {
				times[i]++;
			}
		}

		//2.
		long maxIdx = 0;
		long totalTime = 0;

		//3. ���� 0���� ���۵ɶ� ù��° ���
		for (long i = 0; i < advTime; i++) {
			totalTime += times[i];
		}

		long maxTotalTime = totalTime;
		// �켱 ���� ū �ҿ� �ð�����

		// 4. ���� �ð� ���ķκ��� �����غ�
		for (long i = advTime; i < playTime; i++) {
			totalTime += times[i] - times[i-advTime];
			// ** ���� �ð� ��ŭ�� ���� ��  ***
			if(totalTime > maxTotalTime){
				//5. ���� �ð��� ���� ������
				maxTotalTime = totalTime;
				maxIdx = i - advTime + 1;
			}

		}


		return change(maxIdx);
	}

	long intToTimes (String strTime){
		long[] time = Arrays.stream(strTime.split(":")).mapToInt(Long::parseLong).toArray();
		return 3600*time[0]+60*time[1]+time[2];
	}

	// �ʸ� �ú��ʷ� ��ȯ
	private String change(int seconds) {

		long hours = Math.floorDiv(seconds, 3600);
		long min = Math.floorDiv((seconds - (hours * 3600)), 60);
		long sec = seconds - hours * 3600 - min * 60;
		return addZero(hours) + ":" + addZero(min) + ":" + addZero(sec);

	}

	private String addZero(long num) {
		return ((num < 10) ? "0" : "") + num;
	}

}
