package programmers_lv2;

public class Solution64 {
	public static void main(String[] args) {
		Solution64 s = new Solution64();
		s.solution("aabbaccc");
		
	}
	
	public int solution(String s) {
        int answer = 1000;
        
        int half = s.length()/2;
        
        for (int i = 1; i <= half; i++) { // ����
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
					builder.append(startStr);
				}else {
					// �ϳ��� �����ߴ� ��� 
					builder.append(startStr);
				}
				startStr = ""; // ó������ �ʱ�ȭ 
				cnt=0; // �ߺ����� �ʱ�ȭ�� 
			}
		}
		
		if(cnt>1) {
			// ��� ��ŭ ���� ���� �����ٰ� ��� ������ �ٷ� for �� ������ ���� ��� ��ĥ ���� ���� 
			builder.append(String.valueOf(cnt));
			builder.append(startStr);
		}
		
		if(str.length()%itrVal>0) {
			// ������ �������� �ʴ� ��� 
			int restStartIdx = str.length() - itrVal;
			String restStr = str.substring(restStartIdx);
			builder.append(restStr);
		}
		return builder.length();
	}
}
