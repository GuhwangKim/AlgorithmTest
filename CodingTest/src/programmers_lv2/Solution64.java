package programmers_lv2;

public class Solution64 {
	public int solution(String s) {
        int answer = 0;
        
        int half = s.length()/2;
        
        for (int i = 1; i <= half; i++) {
			int currentLen = check(i, s);
			answer = Math.min(currentLen, answer);
		}
        return answer;
    }

	private int check(int itrVal, String str) {
		StringBuilder builder = new StringBuilder();
		String startStr = "";
		int max = str.length()/itrVal;
		
		for (int i = 0; i < str.length()*(max+1); i+=itrVal) {
			int cnt = 0;
			
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
					builder.append(curStr);
				}else {
					// 하나만 존재했던 경우 
					builder.append(curStr);
				}
				startStr = ""; // 처음문자 초기화 
			}
		}
		
		if(str.length()%itrVal>0) {
			// 나누어 떨어지지 않는 경우 
			int restStartIdx = str.length() - itrVal-1;
			String restStr = str.substring(restStartIdx, str.length());
			builder.append(restStr);
		}
		return builder.length();
	}
}
