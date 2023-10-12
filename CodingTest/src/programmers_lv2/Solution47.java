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

		// 1. 초로 변환한 후 각 초 마다, 값이 있을 경우 1씩 더해줌
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

		//3. 광고가 0부터 시작될때 첫번째 경우
		for (long i = 0; i < advTime; i++) {
			totalTime += times[i];
		}

		long maxTotalTime = totalTime;
		// 우선 가장 큰 소요 시간으로

		// 4. 광고 시간 이후로부터 검증해봄
		for (long i = advTime; i < playTime; i++) {
			totalTime += times[i] - times[i-advTime];
			// ** 광고 시간 만큼의 구간 합  ***
			if(totalTime > maxTotalTime){
				//5. 누적 시간이 가장 많으면
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

	// 초를 시분초로 변환
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
