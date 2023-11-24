package programmers_lv2;

public class Solution64 {
	public static void main(String[] args) {
		Solution64 s = new Solution64();
		s.solution("aabbaccc");
		
	}
	
	public int solution(String s) {
        int answer = s.length();
        int half = s.length()/2;

		if(s.length()==1){
			return 1;
		}
        for (int i = 1; i <= half; i++) { // 간격
			int currentLen = check(i, s);
			answer = Math.min(currentLen, answer);
		}
        return answer;
    }

	private int check(int itrVal, String str) {
		StringBuilder builder = new StringBuilder();
		String startStr = str.substring(0, itrVal); // 처음 값 지정
		int cnt = 1; // 처음값을 지정했으니 1로

		for (int i = itrVal; i <= str.length(); i+=itrVal) { // 문자열의 길이 만큼

			// *** 간격별로 더해주다가, 총 길이보다 커지면, 총 길이를 반환함 **
			int endIdx = Math.min(i+itrVal, str.length());
			String curStr = str.substring(i, endIdx); // 해당 구간 만큼 쪼갬
//			if(startStr.equals("")) {
//				// 값이 존재하지 않는 경우, 처음이거나 아니면 모아지고 난 바로 다음
//				startStr = curStr;
//			}
			if(startStr.equals(curStr)) {
				// 값이 같으면 모아줌 
				cnt++;
				//continue;
			}else {
				if(cnt>1) {
					// 2개이상 존재, 숫자를 집어넣음
					builder.append(cnt);
					// builder.append(startStr);
				}
				builder.append(startStr);
				startStr = curStr;
				cnt=1; // 중복값도 초기화함
//				startStr = ""; // 처음문자 초기화
//				cnt=0; // 중복값도 초기화함
			}
		}
		builder.append(startStr); // 마지막 문자 붙히기
		// endIdx가 생기면서 고려하지 않아도 됨
//		if(cnt>1) {
//			// 배수 만큼 같은 수가 나오다가 배수 끝나고 바로 for 문 밖으로 나온 경우 합칠 것이 있음
//			builder.append(String.valueOf(cnt));
//			builder.append(startStr);
//		}
//
//		if(str.length()%itrVal>0) {
//			// 나누어 떨어지지 않는 경우
//			int restStartIdx = str.length() - itrVal;
//			String restStr = str.substring(restStartIdx);
//			builder.append(restStr);
//		}
		return builder.length();
	}
}
