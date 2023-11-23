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
				// ���� �������� �ʴ� ���, ó���̰ų� �ƴϸ� ������� �� �ٷ� ����
				startStr = curStr;
			}
			
			if(startStr.equals(curStr)) {
				// ���� ������ ����� 
				cnt++;
				continue;
			}else {
				if(cnt>1) {
					// 2���̻� ����, ��ġ�� ��ü 
					builder.append(String.valueOf(cnt));
					builder.append(curStr);
				}else {
					// �ϳ��� �����ߴ� ��� 
					builder.append(curStr);
				}
				startStr = ""; // ó������ �ʱ�ȭ 
			}
		}
		
		if(str.length()%itrVal>0) {
			// ������ �������� �ʴ� ��� 
			int restStartIdx = str.length() - itrVal-1;
			String restStr = str.substring(restStartIdx, str.length());
			builder.append(restStr);
		}
		return builder.length();
	}
}
