package programmers_lv2;

public class Solution64 {
	public static void main(String[] args) {
		Solution64 s = new Solution64();
		s.solution("aabbaccc");
		
	}
	
	public int solution(String s) {
        int answer = 1000;
        
        int half = s.length()/2;
        
        for (int i = 1; i <= half; i++) { // 간격
			int currentLen = check(i, s);
			answer = Math.min(currentLen, answer);
		}
        return answer;
    }

	private int check(int itrVal, String str) {
		StringBuilder builder = new StringBuilder();
		int max = str.length()/itrVal;
		String startStr = "";
		int cnt = 0;

		for (int i = 0; i < itrVal*max; i+=itrVal) {
			String curStr = str.substring(i, i+itrVal);
			if(startStr.equals("")) {
				// 값이 존재하지 않는 경우, 처음이거나 아니면 모아지고 난 바로 다음
				startStr = curStr;
			}
			if(startStr.equals(curStr)) {
				// 값이 같으면 모아줌 
				cnt++;
				continue;
			}else {
				if(cnt>1) {
					// 2개이상 존재, 합치고 대체 
					builder.append(String.valueOf(cnt));
					builder.append(startStr);
				}else {
					// 하나만 존재했던 경우 
					builder.append(startStr);
				}
				startStr = ""; // 처음문자 초기화 
				cnt=0; // 중복값도 초기화함 
			}
		}
		
		if(cnt>1) {
			// 배수 만큼 같은 수가 나오다가 배수 끝나고 바로 for 문 밖으로 나온 경우 합칠 것이 있음 
			builder.append(String.valueOf(cnt));
			builder.append(startStr);
		}
		
		if(str.length()%itrVal>0) {
			// 나누어 떨어지지 않는 경우 
			int restStartIdx = str.length() - itrVal;
			String restStr = str.substring(restStartIdx);
			builder.append(restStr);
		}
		return builder.length();
	}
}
